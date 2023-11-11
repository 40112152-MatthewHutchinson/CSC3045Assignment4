import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
