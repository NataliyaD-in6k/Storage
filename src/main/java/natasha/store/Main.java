package natasha.store;

import natasha.store.dao.CategoryDao;
import natasha.store.dao.CustomerDao;
import natasha.store.dao.ProductDao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection connection;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "root");
//        statement.executeUpdate("INSERT INTO `categories` (`name`) VALUES ('lalala')");

        CategoryDao categoryDao = new CategoryDao(connection);

        ProductDao productDao = new ProductDao(connection, categoryDao);
        Category c = categoryDao.getById(9);
        List<Product> products = new ArrayList<Product>(productDao.getProductsByCategoryId(9));
        for (Product p : products){
            System.out.println(p.getName());
        }

    }



//    private static List<Product> getProducts() throws SQLException {
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT `id`, `name`, `price`, `category_id` FROM `products`");
//        List<Product> products = new ArrayList<Product>();
//
//        while(rs.next()){
//            Product product = new Product(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getBigDecimal("price"),
//                    getById(rs.getInt("category_id"))
//            );
//            products.add(product);
//        }
//        return products;
//    }


}
