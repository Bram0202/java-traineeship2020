package conn;

import java.sql.*;

import static conn.MyProperties.get;

public class App {

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        try (Connection connection = createConnection()) {
            loadDriver();
            Statement statement = createStatement(connection);
            getTableData(statement, "persons");
            betaalZorgtoeslag("Bram", connection, statement);
        } catch (SQLException e) {
            System.err.println("SQLException occured; exiting... Details: \n" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException occured; exiting... Details: \n" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(get("database.url"), get("database.user"), get("database.password"));
    }

    private Statement createStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }

    private void getTableData(Statement statement, String table) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + " (" + age + ")");
        }
    }

    private void betaalZorgtoeslag(String name, Connection connection, Statement statement) throws SQLException {
        try {
            connection.setAutoCommit(false);

            int zorgtoeslag = 100;

            statement.executeUpdate("UPDATE persons SET balance = balance + " + zorgtoeslag + " WHERE name ='" + name + "'");
            statement.executeUpdate("UPDATE belastingdienst SET balance = balance - " + zorgtoeslag);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
