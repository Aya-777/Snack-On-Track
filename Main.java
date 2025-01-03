import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AllMealsFrame.fillLists();
        Details.manageArrayList=loadfiles();
        loadAccounts();
        firstFrame s = new firstFrame();
        try {
            Thread.sleep(2000);
            s.dispose();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        new SignFrame();
        }

            @SuppressWarnings("unchecked")    
        static ArrayList<ArrayList<ArrayList<Integer>>> loadfiles(){
        ArrayList<ArrayList<ArrayList<Integer>>> OrderFiles = new ArrayList<>();
        File file = new File("Orders.dat");
        if(file.exists()){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                OrderFiles = (ArrayList<ArrayList<ArrayList<Integer>>>) ois.readObject();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return OrderFiles;
    }
    @SuppressWarnings("unchecked")
    static void loadAccounts(){
        File customerfile = new File("CustomerAccounts.dat");
        if(customerfile.exists()){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(customerfile))){
                newAccount.customeAccounts = (ArrayList<customerAccounts>) ois.readObject();
            }catch (Exception ee) {
                ee.printStackTrace();
            }
            File managerfile = new File("ManagerAccounts.dat");
            if(managerfile.exists()){
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(managerfile))){
                    newAccount.mangeAccounts = (ArrayList<ManagementAccounts>) ois.readObject();
                }catch (Exception ee) {
                    ee.printStackTrace();
                }
        }
        }
    }
}