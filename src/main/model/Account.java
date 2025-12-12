import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private int balance;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount, String date) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        LocalDate txDate = LocalDate.parse(date, DATE_FORMAT);
        if (!isValidTransactionDate(txDate)) {
            System.out.println("Cannot add transaction with date earlier than existing transactions. Please use a date on or after the last transaction date.");
            return;
        }

        balance += amount;
        transactions.add(new Transaction(txDate, amount, balance));
    }

    @Override
    public void withdraw(int amount, String date) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

        LocalDate txDate = LocalDate.parse(date, DATE_FORMAT);
        if (!isValidTransactionDate(txDate)) {
            System.out.println("Cannot add transaction with date earlier than existing transactions. Please use a date on or after the last transaction date.");
            return;
        }

        balance -= amount;
        transactions.add(new Transaction(txDate, -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE       || AMOUNT || BALANCE");

        // Print oldest to newest (insertion order)
        for (Transaction t : transactions) {
            System.out.println(
                    t.date.format(DATE_FORMAT) + " || " + t.amount + "    || " + t.balanceAfter
            );
        }
    }

    private boolean isValidTransactionDate(LocalDate newDate) {
        if (transactions.isEmpty()) {
            return true;
        }
        
        // Get the date of the last transaction
        LocalDate lastTransactionDate = transactions.get(transactions.size() - 1).date;
        
        // New transaction date must be on or after the last transaction date
        return !newDate.isBefore(lastTransactionDate);
    }

}
