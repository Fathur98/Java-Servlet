package Service;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private String jdbcURL = "jdbc:sqlserver://localhost;databaseName=FR";
    private String jdbcUsername = "foltak";
    private String jdbcPassword = "foltak98";

    private static final String INSERT_USERS_SQL = "INSERT INTO USERS (NAME, EMAIL, COUNTRY) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT ID , NAME, EMAIL, COUNTRY FROM USERS WHERE ID = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM USERS;";
    private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE ID = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE USERS SET NAME = ?, EMAIL = ?, COUNTRY = ? WHERE ID = ?;";

    public UserService() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println("INSERT_USERS_SQL => "+INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        System.out.println("SELECT_USER_BY_ID => "+SELECT_USER_BY_ID);
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String alamat = rs.getString("COUNTRY");
                user = new User(id, nama, email, alamat);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println("SELECT_ALL_USERS => "+SELECT_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nama = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String alamat = rs.getString("COUNTRY");
                users.add(new User(id, nama, email, alamat));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        System.out.println("DELETE_USERS_SQL => "+DELETE_USERS_SQL);
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        System.out.println("UPDATE_USERS_SQL => "+UPDATE_USERS_SQL);
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLSTATE: " + ((SQLException) e).getSQLState());
                System.err.println("ERROR: " + ((SQLException) e).getErrorCode());
                System.err.println("MESSAGE: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("CAUSE: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
