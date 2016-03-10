package natasha.store;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

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
}
