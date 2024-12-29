
public class Meal{

    private int price;
    private int serialnum ;
    private String desc;
    private String name;
    private int cals;
    private boolean deleted;
    private int popularity;

    Meal(int serialnum , int price , String name ,String desc ,int cals , boolean deleted,int popularity){
        this.serialnum=serialnum;
        this.price=price;
        this.desc=desc;
        this.name=name;
        this.cals=cals;
        this.deleted=deleted;
        this.popularity=popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setCals(int cals) {
        this.cals = cals;
    }
    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }
    public int getPrice() {
        return price;
    }
    public String getDesc() {
        return desc;
    }
    public int getCals() {
        return cals;
    }
    public int getSerialnum() {
        return serialnum;
    }
    public String getName() {
        return name;
    }
    boolean getDeleted(){
        return deleted;
    }

}
