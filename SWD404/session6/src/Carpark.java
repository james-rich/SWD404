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
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = car;
                return true;
            }
        }
        return false;
    }

    public boolean removeCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getNumberPlate().equals(car.getNumberPlate())) {
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

    public String[] getNumberPlateList(){
        String[] resultList = new String[15];
        int j = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                j++;
                resultList[j] = cars[i].getNumberPlate();
            }
        }
        return resultList;
    }

}
