package pl.com.sages.spring.io.payback.account;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.sages.spring.io.payback.account.card.CreditCard;
import pl.com.sages.spring.io.payback.data.Entity;

@Data
@AllArgsConstructor
public class Account implements Entity<Long> {

    private Long id;

    private String name;

    private Set<CreditCard> creditCards;

}
