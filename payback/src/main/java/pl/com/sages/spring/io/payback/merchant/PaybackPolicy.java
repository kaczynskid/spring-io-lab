package pl.com.sages.spring.io.payback.merchant;

import static org.joda.money.CurrencyUnit.EUR;
import static org.joda.time.DateTimeConstants.SATURDAY;
import static org.joda.time.DateTimeConstants.SUNDAY;

import org.joda.money.Money;
import org.joda.time.DateTime;

import pl.com.sages.spring.io.payback.merchant.sale.Sale;

public enum PaybackPolicy {

    NEVER {
        @Override
        public boolean isEligible(Money amount, DateTime date) {
            return false;
        }
    },

    ALWAYS {
        @Override
        public boolean isEligible(Money amount, DateTime date) {
            return true;
        }
    },

    WEEKDAYS {
        @Override
        public boolean isEligible(Money amount, DateTime date) {
            int dayOfWeek = date.getDayOfWeek();
            return SATURDAY != dayOfWeek && SUNDAY != dayOfWeek;
        }
    },

    WEEKENDS {
        @Override
        public boolean isEligible(Money amount, DateTime date) {
            int dayOfWeek = date.getDayOfWeek();
            return SATURDAY == dayOfWeek || SUNDAY == dayOfWeek;
        }
    };

    public String getId() {
        return name();
    }

    public abstract boolean isEligible(Money amount, DateTime date);

    public Money applyTo(Sale sale) {
        if (isEligible(sale.getAmount(), sale.getTimestamp())) {
            return sale.getAmount();
        } else {
            return Money.zero(EUR);
        }
    }

}