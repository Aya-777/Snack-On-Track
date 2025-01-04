import java.io.Serializable;
import java.util.ArrayList;

public class customerAccounts implements Serializable {
    private String name;
    private String password;
    private int howManyTimes = 1;
    private Bank bankAccount = null; 
    customerAccounts(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getHowManyTimes() {
        return howManyTimes;
    }

    public void setHowManyTimes(int howManyTimes) {
        this.howManyTimes = howManyTimes;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Bank bankAccount) {
        this.bankAccount = bankAccount;
    }
}