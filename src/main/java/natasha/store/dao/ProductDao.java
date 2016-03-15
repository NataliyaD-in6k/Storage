package natasha.store.dao;

import natasha.store.Category;
import natasha.store.Customer;
import natasha.store.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {
    private Connection connection;
    private CategoryDao categoryDao;

    public ProductDao(Connection connection, CategoryDao categoryDao) {
        this.connection = connection;
        this.categoryDao = categoryDao;
    }

    public Product getById(int product_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM products WHERE id = ?"
        );
        preparedStatement.setInt(1, product_id);
        ResultSet rs = preparedStatement.executeQuery();
        if(!rs.next()){
            return null;
        }
        Product product = new Product( rs.getInt("id"),
                rs.getString("name"),
                rs.getBigDecimal("price"),
                categoryDao.getById(rs.getInt("category_id")));

        return product;
    }

    public List<Product> getAll() throws SQLException {
        ResultSet rs = getStatement().executeQuery("SELECT * FROM products");

        List<Product> products = new ArrayList<Product>();

        while(rs.next()){
            products.add(new Product( rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBigDecimal("price"),
                    categoryDao.getById(rs.getInt("category_id"))));
        }
        return products;
    }

    public void create(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO `products` (`category_id`, `name`, `price`) VALUES (?, ?, ?)"
        );
        statement.setInt(1, product.getCategory().getId());
        statement.setString(2, product.getName());
        statement.setBigDecimal(3, product.getPrice());
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        product.setId(resultSet.getInt(1));
    }
    public void update(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE `products` SET `name`=?,`category_id`=?,`price`=? WHERE `id` = ?"
        );
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCategory().getId());
        preparedStatement.setBigDecimal(3, product.getPrice());
        preparedStatement.setInt(4, product.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM `products` WHERE `id` = ?"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.executeUpdate();
        product.setId(null);
    }

    public Map<Product, Integer> getProductMapByCustomer(Customer customer) throws SQLException {
        Map<Product, Integer> productMap = new HashMap<Product, Integer>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT p.id, p.name, p.price, ctg.id, ctg.name, cp.product_count " +
                        "FROM `customers` c " +
                        "INNER JOIN customer_product cp ON cp.customer_id = c.id " +
                        "INNER JOIN products p ON cp.product_id = p.id " +
                        "INNER JOIN categories ctg ON ctg.id = p.category_id " +
                        "WHERE c.id = ?"
        );
        preparedStatement.setInt(1, customer.getId());
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            Category category = new Category(rs.getInt("ctg.id"), rs.getString("ctg.name"));

            Product product = new Product(rs.getInt("p.id"),
                    rs.getString("p.name"),
                    rs.getBigDecimal("p.price"),
                    category);

            productMap.put(product, rs.getInt("cp.product_count"));
        }
        return productMap;
    }

    public List<Product> getProductsByCategoryId(int category_id) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        ResultSet rs = getStatement().executeQuery("SELECT * FROM `products` WHERE `category_id` = "+category_id);
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                "SELECT * FROM products WHERE category_id = ?"
//        );
//        preparedStatement.setInt(1, category_id);
//        preparedStatement.executeUpdate();

        while(rs.next()){
            products.add(new Product( rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBigDecimal("price"),
                    categoryDao.getById(rs.getInt("category_id"))));
        }

        return products;
    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
