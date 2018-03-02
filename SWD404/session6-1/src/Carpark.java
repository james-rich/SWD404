public class Carpark {
    private Car[] cars;
    private int numberOfSpaces;

    public Carpark() {
        this.cars = new Car[15];
        this.numberOfSpaces = 15;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public boolean addCar(Car car) {
        boolean isCarInList = false;
        int firstSpace = -1;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null){
                if(cars[i].getNumberPlate().equals(car.getNumberPlate())){
                    isCarInList = true;
                }
            }
            if(cars[i] == null && firstSpace < 0){
                firstSpace = i;
            }
        }
        if (!isCarInList && firstSpace >= 0) {
            cars[firstSpace] = car;
            return true;
        }
        return false;
    }

    public boolean removeCar(String car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getNumberPlate().equals(car)) {
                    cars[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumCars(){
        int counter = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                counter += 1;
            }
        }
        return counter;
    }

}
