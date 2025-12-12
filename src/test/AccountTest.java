import java.lang.reflect.Field;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) throws Exception {
        Account account = new Account();

        account.deposit(100, "2024-01-01");
        account.withdraw(40, "2024-01-02");

        int balance = getBalance(account);
        List<Transaction> txs = getTransactions(account);

        if (balance != 60) {
            throw new AssertionError("Expected balance 60, got " + balance);
        }
        if (txs.size() != 2) {
            throw new AssertionError("Expected 2 transactions, got " + txs.size());
        }

        System.out.println("All tests passed.");
    }

    private static int getBalance(Account account) throws Exception {
        Field f = Account.class.getDeclaredField("balance");
        f.setAccessible(true);
        return (int) f.get(account);
    }

    @SuppressWarnings("unchecked")
    private static List<Transaction> getTransactions(Account account) throws Exception {
        Field f = Account.class.getDeclaredField("transactions");
        f.setAccessible(true);
        return (List<Transaction>) f.get(account);
    }
}

