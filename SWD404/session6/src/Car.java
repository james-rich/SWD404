import java.util.Iterator;

public class Car {
    private String numberPlate;

    public Car(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public String toString() {
        return numberPlate;
    }
}
