package natasha.store.promotion;

import natasha.store.Product;

import java.util.List;

public interface Promotion {
    boolean applyPromotion(List<Product> products);

    String getMessage();
}
