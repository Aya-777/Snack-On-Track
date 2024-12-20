import java.io.Serializable;
public class ManagementAccounts implements Serializable {
    private final String name = "employee";
    private String password;
    private final String emploNum = "7879";
    public ManagementAccounts() {
    }
    ManagementAccounts(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getEmploNum() {
        return emploNum;
    }
}