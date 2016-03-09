package natasha.store.discount;

import java.math.BigDecimal;

public class DiscountOfTotalCost implements Discount {
    private int percent;

    public BigDecimal getDiscountSum(BigDecimal totalCost) {
        return new BigDecimal(10);
    }

    public String getMessage() {
        return "lba=bla-bla";
    }
}
