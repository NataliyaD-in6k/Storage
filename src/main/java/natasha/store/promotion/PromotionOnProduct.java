package natasha.store.promotion;

import natasha.store.Product;

import java.math.BigDecimal;
import java.util.List;

public class PromotionOnProduct implements Promotion{
    private Product promotionalProduct;
    private BigDecimal sumOfSale;
    private String message;

    public boolean applyPromotion(List<Product> products) {
        for(Product p: products){
            if (p == promotionalProduct){

            }
        }

        return false;
    }

    public String getMessage() {
        return message;
    }


}
