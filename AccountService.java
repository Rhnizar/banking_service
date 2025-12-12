public interface AccountService {
    void deposit(int amount, String date);
    void withdraw(int amount, String date);
    void printStatement();
}
