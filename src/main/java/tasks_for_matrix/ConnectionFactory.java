package tasks_for_matrix;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static interface Singleton {
        final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    private final DataSource dataSource;

    private ConnectionFactory() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "Passw0rd"); // extract to properties

        GenericObjectPool pool = new GenericObjectPool();
        DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
                "jdbc:mysql://localhost:3306/logger?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", properties
        );
        new PoolableConnectionFactory(
                connectionFactory, pool, null, "SELECT 1", 3, false, false, Connection.TRANSACTION_READ_COMMITTED
        );

        this.dataSource = new PoolingDataSource(pool);
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        getDatabaseConnection();



    }
}
//mysql query for the creating table
// CREATE TABLE LOGS (log_id INT AUTO_INCREMENT NOT NULL,date_time DATETIME NOT NULL, level VARCHAR(10) NOT NULL, message longtext NOT NULL, PRIMARY KEY(log_id));