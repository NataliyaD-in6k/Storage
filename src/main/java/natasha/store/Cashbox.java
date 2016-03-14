package natasha.store;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cashbox {
    private Map<Product, Integer> productCounts = new HashMap<Product, Integer>();
    private Bill bill;

    public Bill createBill(Map<Product, Integer> productCounts){

        return bill;
    }

    public Map<Product, Integer> getProductCounts() {
        return productCounts;
    }

    public void setProductCounts(Map<Product, Integer> productCounts) {
        this.productCounts = productCounts;
    }


    public BigDecimal getTotalCost() {
        BigDecimal totalCost = new BigDecimal(0);
        for (Map.Entry<Product, Integer> entry : productCounts.entrySet()){
            totalCost = totalCost.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
        }
        return totalCost;
    }

}
