package natasha.store.promotion;

import natasha.store.Product;
import natasha.store.ProductPrototype;

import java.math.BigDecimal;
import java.util.List;

public class PromotionOnProduct implements Promotion{
    private ProductPrototype product;
    private String message;
    private BigDecimal discountSum;

    public PromotionOnProduct(ProductPrototype product, String message, BigDecimal discountSum) {
        this.product = product;
        this.message = message;
        this.discountSum = discountSum;
    }

    public boolean applyPromotion(List<Product> products) {
        for(Product p: products){
            if (p.getProductPrototype() == product){

            }
        }

        return false;
    }

    public String getMessage() {
        return message;
    }


}
