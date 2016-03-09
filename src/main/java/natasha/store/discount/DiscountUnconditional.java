package natasha.store.discount;

import java.math.BigDecimal;

public class DiscountUnconditional implements Discount {
    private int percent;

    public BigDecimal getDiscountSum(BigDecimal totalCost) {
        return null;
    }

    public String getMessage() {
        return null;
    }
}
