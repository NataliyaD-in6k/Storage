package natasha.store.dao;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

public class BillDao {
    private Connection connection;

    public BillDao(Connection connection) {
        this.connection = connection;
    }

}
