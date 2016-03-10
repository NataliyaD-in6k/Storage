package natasha.store.dao;

import natasha.store.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private Connection connection;

    public CategoryDao(Connection connection) {
        this.connection = connection;
    }

    public Category getById(int category_id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories WHERE id = ?");
        statement.setInt(1, category_id);
        ResultSet rs = statement.executeQuery();
        if(!rs.next()){
            return null;
        }
        Category category = new Category( rs.getInt("id"), rs.getString("name"));

        return category;
    }

    public List<Category> getAll() throws SQLException {
        ResultSet rs = getStatement().executeQuery("SELECT id, name FROM categories");

        List<Category> categoryList = new ArrayList<Category>();

        while(rs.next()){
            categoryList.add(new Category(rs.getInt("id"), rs.getString("name")));
        }
        return categoryList;
    }

    public void create(Category category) throws SQLException {
        Statement statement = getStatement();
        statement.executeUpdate("INSERT INTO `categories` (`name`) VALUES ('" + category.getName() + "')", Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();

        category.setId(resultSet.getInt(1));
    }
    public void update(Category category) throws SQLException {
        getStatement().executeUpdate("UPDATE `categories` SET `name`='"+category.getName()+"' WHERE `id` ="+category.getId());
    }

    public void delete(Category category) throws SQLException {
        getStatement().executeUpdate("DELETE FROM `store`.`categories` WHERE `categories`.`id` = "+category.getId());
        category.setId(null);
    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
