package natasha.store.dao;

import natasha.store.Category;
import natasha.store.Customer;
import natasha.store.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private Connection connection;
    private ProductDao productDao;

    public CustomerDao(Connection connection, ProductDao productDao) {
        this.connection = connection;
        this.productDao = productDao;
    }

    public Customer getById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `customers` WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }
        Customer customer = new Customer(resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"));

        customer.setProducts(productDao.getProductMapByCustomer(customer));

        return customer;
    }


    public List<Customer> getAll() throws SQLException {
        ResultSet rs = getStatement().executeQuery("SELECT * FROM customers");

        List<Customer> customers = new ArrayList<Customer>();

        while (rs.next()) {
            customers.add(new Customer(rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")));
        }
        for(Customer customer: customers){
            customer.setProducts(productDao.getProductMapByCustomer(customer));
        }

        return customers;
    }

    public void create(Customer customer) throws SQLException {
        Statement statement = getStatement();
        statement.executeUpdate("INSERT INTO `customers` (`first_name`, `last_name`) " +
                "VALUES ('"+customer.getFirstName()+"', '"+customer.getLastName()+"')",
                Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        customer.setId(resultSet.getInt(1));
    }

    public void update(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE `customers` SET `first_name`=?,`last_name`=? WHERE `id` = ?"
        );
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setInt(3, customer.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM `customers` WHERE `id` = ?"
        );
        preparedStatement.setInt(1, customer.getId());
        preparedStatement.executeUpdate();
        customer.setId(null);
    }



    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
