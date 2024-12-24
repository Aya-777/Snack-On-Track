public class Main {
    public static void main(String[] args) {
        firstFrame s = new firstFrame();
        try {
            Thread.sleep(2000);
            s.dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new SignFrame();
    }
}