import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        AllMealsFrame.fillLists();
        // AllMealsFrame.restartapp();
        // try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Meals.dat"))) {
        // oos.writeObject(AllMealsFrame.meallist);
        // } catch (Exception ee) {
        // ee.printStackTrace();
        // }
        loadfiles();
        loadAccounts();
        loadMeals();
        firstFrame s = new firstFrame();
        try {
            Thread.sleep(1500);
            s.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new SignFrame();
    }

    @SuppressWarnings("unchecked")
    static void loadfiles() {
        File file = new File("Orders.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Details.saveFileArray = (ArrayList<OrderFile>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    static void loadAccounts() {
        File customerfile = new File("CustomerAccounts.dat");
        if (customerfile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(customerfile))) {
                newAccount.customeAccounts = (ArrayList<customerAccounts>) ois.readObject();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            File managerfile = new File("ManagerAccounts.dat");
            if (managerfile.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(managerfile))) {
                    newAccount.mangeAccounts = (ArrayList<ManagementAccounts>) ois.readObject();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    static void loadMeals() {
        File mealfile = new File("Meals.dat");
        if (mealfile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mealfile))) {
                AllMealsFrame.meallist = (ArrayList<Meal>) ois.readObject();
                System.out.println(AllMealsFrame.meallist.size());
                for (Meal m : AllMealsFrame.meallist) {
                    AllMealsFrame.order.add(0);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}