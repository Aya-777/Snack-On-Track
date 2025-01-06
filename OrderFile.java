import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

class OrderFile implements Serializable{
    private ArrayList<Integer> order;
    private String username;
    private LocalDate date;
    
    OrderFile(ArrayList<Integer> order, String username,LocalDate date ){
        this.order=order;
        this.username=username;
        this.date= date;
    }

    public void setOrder(ArrayList<Integer> order) {
        this.order = order;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    ArrayList<Integer> getOrder(){
        return order;
    }
    public String getUsername() {
        return username;
    }
    public LocalDate getDate() {
        return date;
    }

}