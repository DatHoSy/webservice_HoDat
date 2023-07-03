package atm;

import java.util.List;

public class Atm {
    private List<Transaction> listTransaction;

    public Atm(List<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public List<Transaction> getListTransaction() {
        return listTransaction;
    }
}