package natasha.store.promotion;

import natasha.store.Product;
import natasha.store.ProductPrototype;

import java.math.BigDecimal;
import java.util.List;

public class PromotionOnProduct implements Promotion{
<<<<<<< HEAD
    private ProductPrototype product;
    private String message;
    private BigDecimal discountSum;

    public PromotionOnProduct(ProductPrototype product, String message, BigDecimal discountSum) {
        this.product = product;
        this.message = message;
        this.discountSum = discountSum;
    }
=======
    private Product promotionalProduct;
    private BigDecimal sumOfSale;
    private String message;
>>>>>>> a0cafd527ca4d9a3c5ae57c535ebb3dcc5432a41

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
