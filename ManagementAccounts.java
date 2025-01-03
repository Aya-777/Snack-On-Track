import java.io.Serializable;
import java.util.ArrayList;

public class ManagementAccounts implements Serializable {
    private final String name = "employee";
    private String password;
    private final String emploNum = "7879";
    private int howManyTimes = 1;
    private Bank bankAccount = null;
    ArrayList<ArrayList<Integer>> myorder=new ArrayList<>();

    public ManagementAccounts() {
    }

    ManagementAccounts(String password) {
        this.password = password;
    }

    public int getHowManyTimes() {
        return howManyTimes;
    }

    public void setHowManyTimes(int howManyTimes) {
        this.howManyTimes = howManyTimes;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmploNum() {
        return emploNum;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Bank bankAccount) {
        this.bankAccount = bankAccount;
    }

}