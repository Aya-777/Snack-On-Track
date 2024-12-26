
public class Bank {
    private String bankName;
    private String cardID;
    private String password;
    private int balance = 100000;

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

}
