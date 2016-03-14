package natasha.store.promotion;

import natasha.store.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PromotionOnGroup implements Promotion{
    private Map<Product, Integer> promotionalProducts;
    private BigDecimal sumOfPromotion;
    private String message;

    public PromotionOnGroup(Map<Product, Integer> promotionalProducts, BigDecimal sumOfPromotion, String message) {
        this.promotionalProducts = promotionalProducts;
        this.sumOfPromotion = sumOfPromotion;
        this.message = message;
    }

    public boolean applyPromotion(List<Product> products) {
        return false;
    }

    public String getMessage() {
        return null;
    }
}
