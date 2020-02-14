package util;

import java.util.ArrayList;
import java.util.Scanner;

public class CarParkingApp {

    private CarPark carPark;
    private int userCarParkSize;

    public CarParkingApp() {
        this.RequestParkSize();

        this.carPark = new CarPark(userCarParkSize);
    }

    private void RequestParkSize() {
        System.out.println("What is the size of the car park: ");

        Scanner in = new Scanner(System.in);

        String tempInput = in.nextLine();

        while (!this.isNumber(tempInput)) {
            System.out.println("Please Input a positive whole number: ");

            tempInput = in.nextLine();
        }

        userCarParkSize = Integer.parseInt(tempInput);
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private ArrayList<Car> GenerateCars() {
        int numberOfCars = (int) (Math.random() * 100); // just keeping it simple... 100 is an assumed average number of cars that turn up on every turn

        ArrayList<Car> generatedCars = new ArrayList<Car>();

        for (int i = 0; i < numberOfCars; i++) {
            generatedCars.add(new Car());
        }

        return generatedCars;
    }

    public void nextTurn() throws InterruptedException {
        this.carPark.ReduceTime();

        this.AddNewCars();

        this.carPark.PrintCars();

        System.out.println("NUMBER OF FREE SPOTS: " + this.carPark.GetNumberOfFreeSpaces());
        if (this.carPark.isFull()) {
            this.carPark.PrintTimeTillFreeCarSpace();
        }
    }

    private void AddNewCars() {
        //System.out.println("------------------------------------------------------------------------------------------");
        ArrayList<Car> newCars = GenerateCars();

        for (Car car : newCars) {
            // System.out.println("New car arriving...");

            // if
            this.carPark.AddNewCar(car);
            // System.out.println("Car successfully parked");
            // else
            //System.out.println("No free spot available");
        }
        //System.out.println("------------------------------------------------------------------------------------------");
    }

}
