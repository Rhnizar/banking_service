import java.time.LocalDate;

public class Transaction {
    public final LocalDate date;
    public final int amount;
    public final int balanceAfter;

    public Transaction(LocalDate date, int amount, int balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }
}