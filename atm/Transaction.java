package atm;

public class Transaction {
    private Account account;
    private double type;
    public Transaction(Account account, double type) {
        this.account = account;
        this.type = type;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public double getType() {
        return type;
    }
    public void setType(double type) {
        this.type = type;
    }
    
}
