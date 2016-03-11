package natasha.store;

public class Cashbox {

    public Bill createBill(ShoppingCart shoppingCart){
        Bill bill = new Bill(shoppingCart.getProducts());
        bill.setTotalCost(shoppingCart.getTotalCost());


        return bill;

    }

}
