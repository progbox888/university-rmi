package storage;

import java.sql.*;

/**
 * Created by Norik on 30.03.2017
 */
public class ConnectionManager {
    private Connection connection;
    private static final ConnectionManager manager = new ConnectionManager();

    private ConnectionManager(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance(){
        return manager;
    }

    public Statement getStatemant() throws SQLException {
        return connection.createStatement();
    }

    public PreparedStatement getPreparedStatemant(String query) throws SQLException {
        return connection.prepareStatement(query);
    }
}
