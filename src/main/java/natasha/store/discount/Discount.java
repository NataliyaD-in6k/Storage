package natasha.store.discount;

import natasha.store.Product;

import java.math.BigDecimal;
import java.util.List;

public interface Discount {
    BigDecimal getDiscountSum(BigDecimal totalCost);
    String getMessage();
}
