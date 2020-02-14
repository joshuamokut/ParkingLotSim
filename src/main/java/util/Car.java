package util;

public class Car implements ParkingAppObject{

    private int timeLeft;
    private int positionInParkingLot;

    protected int getTimeLeft() {
        return timeLeft;
    }

    protected void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    protected int getPositionInParkingLot() {
        return positionInParkingLot;
    }

    protected void setPositionInParkingLot(int positionInParkingLot) {
        this.positionInParkingLot = positionInParkingLot;
    }


    public Car() {
        this.timeLeft = (int) (Math.random() * MAXIMUM_TIME_ALLOWEDIN_PARKING + 1);
    }


}
