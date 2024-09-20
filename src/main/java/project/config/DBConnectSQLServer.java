package project.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSQLServer {
    private final String serverName = "MAYTINHCUAANHDEPTRAI";
    private final String dbName = "BaiTap";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(url, userID, password);

    }

    public static void main(String[] args) {
        try {

            System.out.println(new DBConnectSQLServer().getConnection());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
