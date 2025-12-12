import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
       Account account = new Account();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String command = parts[0];

            try {
                switch (command) {
                    case "deposit":
                        if (parts.length < 3) {
                            System.out.println("Usage: deposit amount date");
                            break;
                        }
                        int depAmount = Integer.parseInt(parts[1]);
                        String depDate = parts[2];
                        if (validateDate(depDate)) {
                            account.deposit(depAmount, depDate);
                        }
                        break;

                    case "withdraw":
                        if (parts.length < 3) {
                            System.out.println("Usage: withdraw amount date");
                            break;
                        }
                        int wAmount = Integer.parseInt(parts[1]);
                        String wDate = parts[2];
                        if (validateDate(wDate)) {
                            account.withdraw(wAmount, wDate);
                        }
                        break;

                    case "print":
                        account.printStatement();
                        break;

                    case "exit":
                        return;

                    default:
                        System.out.println("Unknown command");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error processing command: " + e.getMessage());
            }
        }
    }

    private static boolean validateDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, DATE_FORMAT);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use dd-MM-yyyy");
            return false;
        }
    }
}
