import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount, String date) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount, String date) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
         System.out.println("DATE       | AMOUNT | BALANCE");

        // Print in reverse order (latest first)
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println(
                    t.date + " | " + t.amount + " | " + t.balanceAfter
            );
        }
    }
}
