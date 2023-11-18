import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCommands {
    public static void insertUser(Connection connection, int userId, String log) throws SQLException {
        // SQL query to insert user data
        String sql = "INSERT INTO logs (user_id, log_message) VALUES (?, ?)";

        try (
                // Prepare the SQL statement
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // Set parameters in the prepared statement
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, log);

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        }
    }

    public static void readLog(Connection connection, int id) throws SQLException {

        // Prepare SQL query
        String sql = "SELECT log_message FROM logs WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if there are any logs for the specified user
                if (resultSet.next()) {
                    // Display log entries
                    System.out.println("Log entries for user ID " + id + ":");
                    do {
                        String logMessage = resultSet.getString("log_message");
                        System.out.println(logMessage);
                    } while (resultSet.next());
                } else {
                    System.out.println("No log entries found for user ID " + id);
                }
            }
        }
    }

    public static boolean isValidStaff(Connection connection, int staffId, String password) throws SQLException {
        // Prepare SQL query
        String sql = "SELECT * FROM staff WHERE staff_id = ? AND staff_password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staffId);
            preparedStatement.setString(2, password);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if a matching staff member is found
                return resultSet.next();
            }
        }
    }

}
