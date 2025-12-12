public class Transaction {
    public final String date;
    public final int amount;
    public final int balanceAfter;

    public Transaction(String date, int amount, int balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }
}