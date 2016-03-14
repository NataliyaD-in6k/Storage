package natasha.store;

import natasha.store.discount.DiscountOfTotalCost;
import natasha.store.promotion.PromotionWithGift;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Launch {
//    public static void main(String[] args) {
//        Category category = new Category("v");
//        Category category2 = new Category("v2");
//        List<Product> allProductsInShop = Arrays.asList(new Product("notebook", new BigDecimal(10), category),
//                new Product("pen", new BigDecimal(5), category),
//                new Product("pencil", new BigDecimal(6), category),
//                new Product("gum", new BigDecimal(4), category));
//        List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(allProductsInShop.get(0)),
//                new Product(allProductsInShop.get(1)),
//                new Product(allProductsInShop.get(2)),
//                new Product(allProductsInShop.get(3))));
//        shoppingCart.setProducts(products);
//        shoppingCart.setDiscount(new DiscountOfTotalCost());
//        shoppingCart.setPromotion(new PromotionWithGift(category, allProductsInShop.get(0), "You buy product from a category fruits you get a"));
//        Cashbox cashbox = new Cashbox();
//
//        Bill bill = cashbox.createBill(shoppingCart);
//
//        for (Product product : bill.getProducts()){
//            System.out.print(product.getProductPrototype().getName());
//            System.out.print(".........");
//            System.out.print(product.getProductPrototype().getPrice());
//            System.out.println("/"+product.getDiscountedPrice());
//        }
//        for(String note:bill.getNotes()){
//            System.out.println(note);
//        }
//        System.out.println(bill.getTotalCost());
//        System.out.println(bill.getDiscountedTotalCost());
//
//
//    }
}
