package natasha.store;

import java.math.BigDecimal;

public class Product {//TODO: rename class
    private ProductPrototype productPrototype;
    private BigDecimal discountedPrice;

    public Product(ProductPrototype productPrototype) {
        this.productPrototype = productPrototype;
        this.discountedPrice = productPrototype.getPrice();
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public ProductPrototype getProductPrototype() {
        return productPrototype;
    }

    public BigDecimal getPrice(){
        return productPrototype.getPrice();
    }

    public Category getCategory(){
        return productPrototype.getCategory();
    }
}
