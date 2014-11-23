package pl.com.sages.spring.io.payback.account.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.sages.spring.io.payback.data.Entity;

@Data
@AllArgsConstructor
public class CreditCard implements Entity<Long> {

    private Long id;

    private String number;

}
