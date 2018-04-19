public class Enclosure {
    private int     enclosureNumber;
    private int     enclosureDaysBookedIn;
    private double   enclosurePricePerDay;
    private Dog     enclosureOccupant;

    public Enclosure(int enclosureNumber, float enclosurePricePerDay) {
        this.enclosureNumber = enclosureNumber;
        this.enclosureDaysBookedIn = 0;
        this.enclosurePricePerDay = enclosurePricePerDay;
        this.enclosureOccupant = null;
    }

    public int getEnclosureNumber() {
        return enclosureNumber;
    }


    public int getEnclosureDaysBookedIn() {
        return enclosureDaysBookedIn;
    }

    public void setEnclosureDaysBookedIn(int enclosureDaysBookedIn) {
        this.enclosureDaysBookedIn = enclosureDaysBookedIn;
    }

    public double getEnclosurePricePerDay() {
        return enclosurePricePerDay;
    }

    public Dog getEnclosureOccupant() {
        return enclosureOccupant;
    }

    public void setEnclosureOccupant(Dog enclosureOccupant) {
        this.enclosureOccupant = enclosureOccupant;
    }


}
