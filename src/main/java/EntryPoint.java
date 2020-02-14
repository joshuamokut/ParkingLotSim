import util.CarPark;
import util.CarParkingApp;

public class EntryPoint {
    public static void main(String[] args) throws InterruptedException {
        CarParkingApp app = new CarParkingApp();

        
        while (true) {
            app.nextTurn();
            Thread.sleep(1000);
        }


    }
}
