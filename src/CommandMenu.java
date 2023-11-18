import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
public class CommandMenu {

    private final DbConnect connect = new DbConnect();
    private Scanner scanner;

    public CommandMenu() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu(Connection connection) throws SQLException {
        String choice;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Enter Logs");
            System.out.println("2. Read Logs");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    connect.addLog(connection);
                    System.out.println("You selected Option 1");
                    break;
                case "2":
                    connect.readLogs(connection);
                    System.out.println("You selected Option 2");
                    break;
                case "3":
                    System.out.println("Exiting the menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (!choice.equals("3"));

        scanner.close();
    }
}
