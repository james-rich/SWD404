public class Car {
    private String make;
    private String model;
    private int numOfDoors;
    private int numOfSeats;
    private double engineSize;

    private int currentSpeed;
    private int maxSpeed;
    private int fuelLevel;

    public Car() {
        this.make = "no make";
        this.model = "no model";
        this.numOfDoors = 0;
        this.numOfSeats = 0;
        this.engineSize = 0;
        this.currentSpeed = 0;
        this.maxSpeed = 0;
        this.fuelLevel = 0;
    }

    public Car(String makeIn, String modelIn, int numOfDoorsIn, int numOfSeatsIn, double engineSizeIn, int currentSpeedIn, int maxSpeedIn, int fuelLevelIn) {
        this.make = makeIn;
        this.model = modelIn;
        this.numOfDoors = numOfDoorsIn;
        this.numOfSeats = numOfSeatsIn;
        this.engineSize = engineSizeIn;
        this.currentSpeed = currentSpeedIn;
        this.maxSpeed = maxSpeedIn;
        this.fuelLevel = fuelLevelIn;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void accelerate(int speed){
        if((currentSpeed + speed) <= maxSpeed) {
            currentSpeed += speed;
        }else{
            currentSpeed = maxSpeed;
        }
    }

    public void brake(int brake){
        if((currentSpeed - brake) >= 0) {
            currentSpeed -= brake;
        }else{
            currentSpeed = 0;
        }
    }

    public void refuel(int fuel){
        if((fuelLevel + fuel) <= 100){
            fuelLevel += fuel;
        }else{
            fuelLevel = 100;
        }
    }


    public static void main(String[] args){
        Car car1 = new Car("Ford", "Focus", 4, 4, 1.8, 25, 120, 34);

        Car car2 = new Car();
        car2.setMake("Ford");
        car2.setModel("Mustang");
        car2.setEngineSize(5.0);
        car2.setNumOfDoors(2);
        car2.setNumOfSeats(2);
        car2.setCurrentSpeed(145);
        car2.setMaxSpeed(155);
        car2.setFuelLevel(74);

        System.out.println("Make:            " + car1.getMake() +
                "\nModel:           " + car1.getModel() +
                "\nEngine size:     " + car1.getEngineSize() +
                "\nNumber of doors: " + car1.getNumOfDoors() +
                "\nNumber of seats: " + car1.getNumOfSeats() +
                "\nCurrent speed:   " + car1.getCurrentSpeed() +
                "\nMax speed:       " + car1.getMaxSpeed() +
                "\nFuel level:      " + car1.getFuelLevel());

        System.out.println();

        System.out.println("Make:            " + car2.getMake() +
                "\nModel:           " + car2.getModel() +
                "\nEngine size:     " + car2.getEngineSize() +
                "\nNumber of doors: " + car2.getNumOfDoors() +
                "\nNumber of seats: " + car2.getNumOfSeats() +
                "\nCurrent speed:   " + car2.getCurrentSpeed() +
                "\nMax speed:       " + car2.getMaxSpeed() +
                "\nFuel level:      " + car2.getFuelLevel());

        System.out.println();

        car1.refuel(10);
        car1.brake(35);

        System.out.println("Make:            " + car1.getMake() +
                "\nModel:           " + car1.getModel() +
                "\nEngine size:     " + car1.getEngineSize() +
                "\nNumber of doors: " + car1.getNumOfDoors() +
                "\nNumber of seats: " + car1.getNumOfSeats() +
                "\nCurrent speed:   " + car1.getCurrentSpeed() +
                "\nMax speed:       " + car1.getMaxSpeed() +
                "\nFuel level:      " + car1.getFuelLevel());

        System.out.println();

        car2.accelerate(10);

        System.out.println("Make:            " + car2.getMake() +
                "\nModel:           " + car2.getModel() +
                "\nEngine size:     " + car2.getEngineSize() +
                "\nNumber of doors: " + car2.getNumOfDoors() +
                "\nNumber of seats: " + car2.getNumOfSeats() +
                "\nCurrent speed:   " + car2.getCurrentSpeed() +
                "\nMax speed:       " + car2.getMaxSpeed() +
                "\nFuel level:      " + car2.getFuelLevel());
    }
}

