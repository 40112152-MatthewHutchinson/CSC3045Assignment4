import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static Connection connection; // Declare the Connection as a class variable

    public static void main(String[] args) throws SQLException {

        Main main = new Main();

        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "username";
        String password = "password";

        main.openConnection(url, user, password);

        CommandMenu menu = new CommandMenu();
        menu.displayMenu(connection);

        main.closeConnection();

    }

    public void openConnection(String url, String user, String password) {
        try {
            // Establish a database connection
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Database connection established.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}