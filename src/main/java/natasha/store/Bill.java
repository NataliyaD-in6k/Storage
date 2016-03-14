package natasha.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bill {
    private Integer id;
    private Map<Product, Integer> productCounts;
    private BigDecimal totalCost;
    private BigDecimal discountedTotalCost;
    private List<String> notes = new ArrayList<String>();


    public Bill(Map<Product, Integer> productCounts) {
        this.productCounts = productCounts;
    }

    public Map<Product, Integer> getProductCounts() {
        return productCounts;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getDiscountedTotalCost() {
        return discountedTotalCost;
    }

    public void setDiscountedTotalCost(BigDecimal discountedTotalCost) {
        this.discountedTotalCost = discountedTotalCost;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void addNote(String note) {
        if (note != null) {
            notes.add(note);
        }
    }
}
