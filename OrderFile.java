import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

class OrderFile implements Serializable {
    private ArrayList<Integer> order;
    private String username;
    private LocalDate date;
    private String status;
    private int orderPrice;

    private myAccount m1 = new myAccount();
    static ArrayList<OrderFile> list = new ArrayList<>();

    OrderFile(ArrayList<Integer> order, String status, int price) {
        this.order = order;
        this.username = m1.getUserName();
        this.status = status;
        this.date = LocalDate.now();
        this.orderPrice = price;
    }

    public ArrayList<Integer> getOrder() {
        return order;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}