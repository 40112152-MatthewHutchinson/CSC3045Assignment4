import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DbConnect {
    // Database connection parameters

    public void addLog(Connection connection) throws SQLException {

        // Prompt user for input
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter user ID: ");
            int userId = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter log message: ");
            String log = scanner.nextLine();

            // Insert user data into the database
            SqlCommands.insertUser(connection, userId, log);

            System.out.println("User data inserted successfully.");
        }catch(InputMismatchException e) {
            System.out.println("Invalid.You have entered a non-integer");
            scanner.next();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e );
        }
    }

    public void readLogs(Connection connection) throws SQLException {
        // Prompt user for input
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Staff ID: ");
            int staffId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            boolean isValid = SqlCommands.isValidStaff(connection, staffId, password);

            if (isValid) {
                System.out.print("Enter user ID to display logs: ");
                int userId = scanner.nextInt();
                scanner.nextLine();
                SqlCommands.readLog(connection, userId);
            } else {
                System.out.println("Invalid staff ID or password.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid.You have entered a non-integer");
            scanner.next();
        } catch (Exception e) {
            System.out.println("An error has occured: " + e );
        }

    }

}
