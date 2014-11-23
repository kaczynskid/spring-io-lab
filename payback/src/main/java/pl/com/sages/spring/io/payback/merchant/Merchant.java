package pl.com.sages.spring.io.payback.merchant;

import static java.math.RoundingMode.HALF_EVEN;

import org.joda.money.Money;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.sages.spring.io.payback.account.Account;
import pl.com.sages.spring.io.payback.data.Entity;
import pl.com.sages.spring.io.payback.merchant.sale.Sale;
import pl.com.sages.spring.io.payback.payback.Percentage;

@Data
@AllArgsConstructor
public class Merchant implements Entity<Long> {

    private Long id;

    private String name;

    private Percentage paybackRate;

    private PaybackPolicy paybackPolicy;

    public Money calculatePaybackFor(Account account, Sale sale) {
        return paybackPolicy.applyTo(sale).multipliedBy(paybackRate.asBigDecimal(), HALF_EVEN);
    }
}
