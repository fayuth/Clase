package bank.cuenta;

public class Account {

    private String AccountNumber;

    private double Balance;

    private final String AccountType;



    public Account(String AccountNumber, int Balance, String AccountType) {
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
        this.AccountType = AccountType;
    }

    public boolean deposit(double monto) {
        if(monto > 0) {
            Balance += monto;
        }
        return false;
    }

    public boolean retira(double monto) {
        if(monto > 0 && monto <= Balance){
            Balance -= monto;
            return true;
        }
        return false;
    }

    public String getAccountType() {
        return AccountType;
    }

    public double getBalance() {
        return Balance;
    }
}
