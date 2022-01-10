package MySQL;

import java.sql.*;
import java.util.Objects;

public class DBConnector<T> {
    private static Connection connection;
    private ResultSet resultSet;

    public abstract T execute();

    private Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Statement getStatement() {
        try {
            return Objects.requireNonNull(getConnection()).createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void executeUpdate(String query) {
        try {
            Objects.requireNonNull(getStatement()).executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void executeQuery(String query) {
        try {
            resultSet = Objects.requireNonNull(getStatement()).executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
