public class Booking {

    private String name;
    private int numberOfGuests;
    private boolean isOutside;

    public Booking(String name, int numberOfGuests, boolean isOutside) {
        this.name = name;
        this.numberOfGuests = numberOfGuests;
        this.isOutside = isOutside;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isOutside() {
        return isOutside;
    }
}
