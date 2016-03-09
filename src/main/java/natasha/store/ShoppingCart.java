package natasha.store;

import natasha.store.discount.Discount;
import natasha.store.promotion.Promotion;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private Discount discount;
    private Promotion promotion;
    private List<Product> products;



    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = new BigDecimal(0);
        for (Product product: products){
            totalCost = totalCost.add(product.getPrice());
        }
        return totalCost;
    }

    public BigDecimal getDiscountSum() {
        if(discount == null){
            return new BigDecimal(0);
        }
        return discount.getDiscountSum(getTotalCost());
    }

    public String getDiscountMessage(){
        if (discount == null){
            return null;
        }
        return discount.getMessage();
    }

    public boolean applyPromotion(){
        if(promotion == null){
            return false;
        }
        return promotion.applyPromotion(products);

    }

    public String getPromotionMessage(){
        if (promotion == null){
            return null;
        }
        return promotion.getMessage();
    }
}
