package util;

public class CarPark implements ParkingAppObject {

    private int carParkSize;
    private Car carPlaces[];

    public CarPark(int carParkSize) {
        this.carParkSize = carParkSize;

        this.carPlaces = new Car[carParkSize];
    }

    protected int GetNumberOfFreeSpaces() {
        int numberOfFreeSpaces = 0;

        for (int i = 0; i < carParkSize; i++) {
            numberOfFreeSpaces += carPlaces[i] == null ? 0 : 1;
        }

        return numberOfFreeSpaces;
    }

    protected int GetTimeTillFreeCarSpace() {
        int minimumTimeLeft = MAXIMUM_TIME_ALLOWEDIN_PARKING + 1;

        for (int i = 0; i < carParkSize; i++) {
            minimumTimeLeft = Math.min(minimumTimeLeft, carPlaces[i].getTimeLeft());
        }

        return minimumTimeLeft;
    }

    protected void ReduceTime(){
        for(int i=0; i<carParkSize; i++){
            if (carPlaces[i]!=null){
                carPlaces[i].setTimeLeft(carPlaces[i].getTimeLeft()-1);

                if (carPlaces[i].getTimeLeft()==0){
                    carPlaces[i]=null;
                }
            }
        }
    }

    private int GetFreeSpot(){
        for(int i=0; i<carParkSize; i++){
            if (carPlaces[i]==null)
                return i;
        }
        return -1;
    }

    protected boolean isFull(){
        return GetFreeSpot()==-1;
    }

    protected void PrintTimeTillFreeCarSpace(){
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("FREE SPOT AVAILABLE IN "+ this.GetTimeTillFreeCarSpace());

        System.out.println("------------------------------------------------------------------------------------------");
    }

    protected boolean AddNewCar(Car car){
         int freeSpot = GetFreeSpot();

         if (freeSpot==-1)
             return false;

         carPlaces[freeSpot]=car;

         return true;
    }

    protected void PrintCars() throws InterruptedException {
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("CARS CURRENTLY IN PARKING:");

        for(int i=0; i<carParkSize; i++){
            if (carPlaces[i]!=null){
                System.out.println("Car at spot number "+
                        Integer.toString(i+1) + ".  " +
                        Integer.toString(carPlaces[i].getTimeLeft())+" turns left.");
                Thread.sleep(500);
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
