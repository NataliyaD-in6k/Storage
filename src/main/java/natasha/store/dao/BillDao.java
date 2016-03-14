package natasha.store.dao;

import natasha.store.Bill;
import natasha.store.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class BillDao {
    private Connection connection;
    private BillNoticeDao billNoticeDao;

    public BillDao(Connection connection) {
        this.connection = connection;
    }

//    public Bill getById(int id) throws SQLException {
//        connection.createStatement();
//        return new Bill();
//    }
}
