package natasha.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> products;
    private BigDecimal totalCost;
    private BigDecimal discountedTotalCost;
    private List<String> notes = new ArrayList<String>();

    public Bill(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
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
