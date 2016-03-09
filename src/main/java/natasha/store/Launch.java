package natasha.store;

import natasha.store.discount.Discount;
import natasha.store.discount.DiscountOfTotalCost;
import natasha.store.promotion.PromotionWithGift;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Category category = new Category("v");
        Category category2 = new Category("v2");
        List<ProductPrototype> allProductsInShop = Arrays.asList(new ProductPrototype("notebook", new BigDecimal(10), category),
                new ProductPrototype("pen", new BigDecimal(5), category),
                new ProductPrototype("pencil", new BigDecimal(6), category),
                new ProductPrototype("gum", new BigDecimal(4), category));
        List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(allProductsInShop.get(0)),
                new Product(allProductsInShop.get(1)),
                new Product(allProductsInShop.get(2)),
                new Product(allProductsInShop.get(3))));
        shoppingCart.setProducts(products);
        shoppingCart.setDiscount(new DiscountOfTotalCost());
        shoppingCart.setPromotion(new PromotionWithGift(category, allProductsInShop.get(0), "Gift!!"));
        Cashbox cashbox = new Cashbox();

        Bill bill = cashbox.createBill(shoppingCart);

        for (Product product : bill.getProducts()){
            System.out.print(product.getProductPrototype().getName());
            System.out.print(".........");
            System.out.print(product.getProductPrototype().getPrice());
            System.out.println("/"+product.getDiscountedPrice());
        }
        for(String note:bill.getNotes()){
            System.out.println(note);
        }
        System.out.println(bill.getTotalCost());
        System.out.println(bill.getDiscountedTotalCost());


    }
}
