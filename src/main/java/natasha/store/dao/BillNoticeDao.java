package natasha.store.dao;

import natasha.store.BillNotice;
import natasha.store.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillNoticeDao {
    private Connection connection;

    public BillNoticeDao(Connection connection) {
        this.connection = connection;
    }

    public BillNotice getById(int billNotice_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM products WHERE id = ?"
        );
        preparedStatement.setInt(1, billNotice_id);
        ResultSet rs = preparedStatement.executeQuery();
        if(!rs.next()){
            return null;
        }
        BillNotice billNotice = new BillNotice(rs.getInt("id"),
                rs.getString("name"));

        return billNotice;
    }
//
//    public List<BillNotice> getAll() throws SQLException {
//        ResultSet rs = getStatement().executeQuery("SELECT * FROM products");
//
//        List<BillNotice> billNotices = new ArrayList<Product>();
//
//        while(rs.next()){
//            products.add(new Product( rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getBigDecimal("price"),
//                    categoryDao.getById(rs.getInt("category_id"))));
//        }
//        return products;
//    }

    private Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

}
