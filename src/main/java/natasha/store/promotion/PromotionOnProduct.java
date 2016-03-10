package natasha.store.promotion;

import natasha.store.Product;

import java.math.BigDecimal;
import java.util.List;

public class PromotionOnProduct implements Promotion{
    private Product promotionalProduct;
    private BigDecimal sumOfSale;
    private String message;

    public boolean applyPromotion(List<Product> products) {
        return false;
    }

    public String getMessage() {
        return null;
    }


}
