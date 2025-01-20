import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable{
    private String bankName;
    private String cardID;
    private String password;
    private int balance = 1000;

    static ArrayList<Bank> list = new ArrayList<>();

    public Bank() {
    }

    public Bank(String bankName, String cardID, String password) {
        this.bankName = bankName;
        this.cardID = cardID;
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCardID() {
        return cardID;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}