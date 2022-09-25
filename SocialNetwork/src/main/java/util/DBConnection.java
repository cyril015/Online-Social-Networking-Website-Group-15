package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/social_network";
    String username = "root";
    String password = "sakshi";

    /*private String url = "jdbc:mysql://localhost:3306/social-network";
    private String username = "root";
    private String password = "sakshi";*/

    private DBConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	this.connection= DriverManager.getConnection(url, username, password);

            //Class.forName("com.mysql.jdbc.Driver");
            //this.connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection Created");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }
}
