import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "username";
        String password = "password";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection!=null){
                System.out.println("Database OK");
            }else{
                System.out.println("DB FAILED");
            }
            //            // Prompt user for input
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Enter user ID: ");
//            int userId = scanner.nextInt();
//
//            scanner.nextLine();
//
//            System.out.print("Enter log message: ");
//            String log = scanner.nextLine();
//
//            // Insert user data into the database
//            insertUser(connection, userId, log);
//
//            System.out.println("User data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private static void insertUser(Connection connection, int userId, String log) throws SQLException {
//        // SQL query to insert user data
//        String sql = "INSERT INTO logs (user_id, log_message) VALUES (?, ?)";
//
//        try (
//                // Prepare the SQL statement
//                PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            // Set parameters in the prepared statement
//            preparedStatement.setInt(1, userId);
//            preparedStatement.setString(2, log);
//
//            // Execute the SQL statement
//            preparedStatement.executeUpdate();
//        }
//    }
}