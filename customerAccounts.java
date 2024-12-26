import java.io.Serializable;

public class customerAccounts implements Serializable {
    private String name;
    private String password;
    private int howManyTimes = 0;

    
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
}
