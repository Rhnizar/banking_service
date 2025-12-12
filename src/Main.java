import java.util.Scanner;

public class Main {
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
                        account.deposit(depAmount, depDate);
                        break;

                    case "withdraw":
                        if (parts.length < 3) {
                            System.out.println("Usage: withdraw amount date");
                            break;
                        }
                        int wAmount = Integer.parseInt(parts[1]);
                        String wDate = parts[2];
                        account.withdraw(wAmount, wDate);
                        break;

                    case "print":
                        account.printStatement();
                        break;

                    case "exit":
                        return;

                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error processing command.");
            }
        }
    }
}
