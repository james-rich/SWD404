public class Vehicle {
    private double engineSize;
    private double mpg;
    private int numberOfSeats;
    private int numberOfDoors;
    private double fuelLevel;
    private double fuelCapacityGallons;
    private int numberOfPassengers;

    public Vehicle() {
        this.engineSize = 0;
        this.mpg = 0;
        this.numberOfSeats = 0;
        this.numberOfDoors = 0;
        this.fuelLevel = 0;
        this.fuelCapacityGallons = 0;
        this.numberOfPassengers = 0;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getFuelCapacityGallons() {
        return fuelCapacityGallons;
    }

    public void setFuelCapacityGallons(double fuelCapacityGallons) {
        this.fuelCapacityGallons = fuelCapacityGallons;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void driveVehicle(double milesDriven){
        double fuelInGallions = (this.fuelLevel / 100) * this.fuelCapacityGallons;
        System.out.println(fuelInGallions);
        System.out.println("Start of journey: "+ fuelLevel);
        double result = fuelInGallions - (milesDriven / mpg);
        System.out.println(result);
        double newFuelLevel = (result / this.fuelCapacityGallons) * 100;
        System.out.println("End of journey: "+ String.format("%f", newFuelLevel));
    }

    public boolean addPassanger(int newPassengers){
        if(this.numberOfSeats >= (this.numberOfPassengers + newPassengers)) {
            this.numberOfPassengers += newPassengers;
            return true;
        }else{
            System.out.println("Sorry this vehicle is full.");
        }
        return false;
    }
}
