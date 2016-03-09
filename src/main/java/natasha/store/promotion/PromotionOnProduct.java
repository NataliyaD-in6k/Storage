package natasha.store.promotion;

import natasha.store.Product;

import java.util.List;

public class PromotionOnProduct implements Promotion{
    public boolean applyPromotion(List<Product> products) {
        return false;
    }

    public String getMessage() {
        return null;
    }


}
