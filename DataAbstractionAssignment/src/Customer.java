import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        this.name = "John Doe";
        this.accountNumber = 1;
        this.checkBalance = 200;
        this.savingBalance = 200;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    //Requires: double, date, string
    //Modifies: this
    //Effects: Adds another instance of deposit to ArrayList deposits
    public double deposit(double amt, Date date, String account){
        if (amt <= 0 || (account != CHECKING && account != SAVING)) {
            return 0;
        }

        deposits.add(new Deposit(amt, date, account));

        if (account == CHECKING) {
            checkBalance += amt;
            return checkBalance;
        } else {
            savingBalance += amt;
            return savingBalance;
        }
    }

    //Requires: double, date, string
    // Modifies: this
    // Effects: Adds another instance of withdraw to ArrayList withdraws
    public double withdraw(double amt, Date date, String account){
        if (amt <= 0 || checkOverdraft(amt, account) || (account != CHECKING && account != SAVING)) {
            return -101;
        }

        withdraws.add(new Withdraw(amt, date, account));

        if (account == CHECKING) {
            checkBalance -= amt;
            return checkBalance;
        } else {
            savingBalance -= amt;
            return savingBalance;
        }
    }

    private boolean checkOverdraft(double amt, String account){
        if (account == CHECKING) {
            if (checkBalance - amt < OVERDRAFT) {
                return true;
            } else return false;
        } else {
            if (savingBalance - amt < OVERDRAFT) {
                return true;
            } else return false;
        }
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
