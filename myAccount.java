public class myAccount {
    static customerAccounts customer = null;
    static ManagementAccounts employee = null;
    static Bank bankAccount = null;

    boolean havingAccount() {
        if (employee != null || customer != null) {
            return true;
        } else {
            return false;
        }
    }

    boolean whichOne() {
        if (employee == null && customer != null) {
            return true; // customer account
        } else {
            return false; // employee account
        }
    }
}