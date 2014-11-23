package pl.com.sages.spring.io.payback.payback;

import org.joda.money.Money;
import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.sages.spring.io.payback.account.Account;
import pl.com.sages.spring.io.payback.data.Entity;
import pl.com.sages.spring.io.payback.merchant.Merchant;
import pl.com.sages.spring.io.payback.merchant.sale.Sale;

@Data
@AllArgsConstructor
public class Payback implements Entity<Long> {

    private Long id;

    private Account account;

    private Merchant merchant;

    private Sale sale;

    private DateTime timestamp;

    private Money amount;
}
