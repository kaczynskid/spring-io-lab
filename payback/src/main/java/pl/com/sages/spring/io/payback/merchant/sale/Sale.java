package pl.com.sages.spring.io.payback.merchant.sale;

import org.joda.money.Money;
import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sale {

    private Long id;

    private DateTime timestamp;

    private Long merchantId;

    private String creditCardNumber;

    private Money amount;

}
