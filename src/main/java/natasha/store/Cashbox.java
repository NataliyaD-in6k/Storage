package natasha.store;

public class Cashbox {

    public Bill createBill(ShoppingCart shoppingCart){
        Bill bill = new Bill(shoppingCart.getProducts());
        bill.setTotalCost(shoppingCart.getTotalCost());

        bill.setDiscountedTotalCost(shoppingCart.getTotalCost().add(shoppingCart.getDiscountSum().negate()));
        bill.addNote(shoppingCart.getDiscountMessage());

        if(shoppingCart.applyPromotion()){
            bill.addNote(shoppingCart.getPromotionMessage());
        }
        return bill;
    }

}
