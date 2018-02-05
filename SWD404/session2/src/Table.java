import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableNumber;
    private int numberOfSeats;
    private boolean isOutside;
    private Staff staff;
    private Booking booking;
    private boolean isBooked;

    public Table(int tableNumber, int numberOfSeats, boolean isOutside) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
        this.isOutside = isOutside;
        this.staff = null;
        this.booking = null;
    }

    public void AssingStaffMember(Staff staff){
        this.staff = staff;
    }

    public void BookTable(Booking booking){
        if(this.isOutside && booking.isOutside() && this.numberOfSeats >= booking.getNumberOfGuests()) {
            this.booking = booking;
            this.isBooked = true;
        }else if(!booking.isOutside() && this.numberOfSeats >= booking.getNumberOfGuests()){
            this.booking = booking;
            this.isBooked = true;
        }else{
            System.out.println("Sorry we cant fit you in at this time!");
        }
    }

    public static void main(String[] args) {

        Table table1 = new Table(1, 4, true);
        Table table2 = new Table(2, 6, false);
        Table table3 = new Table(3, 2, false);

        Booking booking1 = new Booking("James", 2, true);
        Booking booking2 = new Booking("Arron", 4, true);
        Booking booking3 = new Booking("Darren", 10, true);

        Staff staff1 = new Staff("Anna", 21);
        Staff staff2 = new Staff("Jim", 17);

        System.out.println(table1.booking);
        table1.BookTable(booking3);
        table1.AssingStaffMember(staff1);
        try {
            System.out.println(table1.booking.getName());
        }catch (NullPointerException e){
            System.out.println("Error! No booking name set.");
        }

        try {
            System.out.println(table1.staff.getName());
        }catch (NullPointerException e){
            System.out.println("Error! No staff name set.");
        }

    }
}
