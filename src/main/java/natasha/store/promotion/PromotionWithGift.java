package natasha.store.promotion;

import natasha.store.Category;
import natasha.store.Product;

import java.math.BigDecimal;
import java.util.List;

public class PromotionWithGift implements Promotion {
    private Category category;
    private Product giftPrototype;
    private String message;

    public PromotionWithGift(Category category, Product giftPrototype, String message) {
        this.category = category;
        this.giftPrototype = giftPrototype;
        this.message = message;
    }

    public boolean applyPromotion(List<Product> products) {
        for (Product p : products) {
            if (p.getCategory() == category) {
//                Product gift = new Product(giftPrototype);
//                products.add(gift);
                return true;
            }
        }
        return false;
    }

    public String getMessage() {
        return message;
    }


}
