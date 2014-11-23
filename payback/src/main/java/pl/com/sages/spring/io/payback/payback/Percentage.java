package pl.com.sages.spring.io.payback.payback;

import java.io.Serializable;
import java.math.BigDecimal;

public class Percentage implements Serializable {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private static final BigDecimal ONE_HUNDREDTH = new BigDecimal("0.01");

    private BigDecimal value;

    public Percentage(BigDecimal value) {
        initValue(value);
    }

    public Percentage(double value) {
        initValue(BigDecimal.valueOf(value));
    }

    private void initValue(BigDecimal value) {
        value = value.setScale(2, BigDecimal.ROUND_HALF_UP);
        if (value.compareTo(BigDecimal.ZERO) == -1 || value.compareTo(BigDecimal.ONE) == 1) {
            throw new IllegalArgumentException("Percentage value must be between 0 and 1; your value was " + value);
        }
        this.value = value;
    }

    public static Percentage of(String string) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("The percentage value is required");
        }
        if (string.endsWith("%")) {
            int index = string.lastIndexOf('%');
            string = string.substring(0, index);
        }
        BigDecimal value = new BigDecimal(string);
        if (value.compareTo(ONE_HUNDREDTH) == -1 || value.compareTo(BigDecimal.ONE) == 1) {
            value = value.divide(ONE_HUNDRED);
        }
        return new Percentage(value);
    }

    public static Percentage zero() {
        return new Percentage(0);
    }

    public static Percentage oneHundred() {
        return new Percentage(1);
    }

    public Percentage add(Percentage percentage) throws IllegalArgumentException {
        return new Percentage(value.add(percentage.value));
    }

    public BigDecimal asBigDecimal() {
        return value;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Percentage)) {
            return false;
        }
        return value.equals(((Percentage) o).value);
    }

    public int hashCode() {
        return value.hashCode();
    }

    public String toString() {
        return value.multiply(ONE_HUNDRED).setScale(0) + "%";
    }
}
