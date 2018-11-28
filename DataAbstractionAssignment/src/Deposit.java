import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Effects: Prints out how much deposited, the date of deposit, and into which account
    public String toString(){
        return "Deposit of: " + amount + " Date: " + date + " into account: " + account;
    }
}
