package natasha.store.discount;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getDiscountSum(BigDecimal totalCost);
    String getMessage();
}
