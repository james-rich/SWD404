import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println();
        int riders;
        Company company = new Company("Solent Busses");
        Bus bus1 = new Bus(68, 15);
        company.addBus(bus1);
        Person passenger1 = new Person("james", 387, 33, 10.55);
        Person passenger2 = new Person("aaron", 365, 28, 11);
        Person passenger3 = new Person("Darren", 843, 38, 5.61);

        bus1.addPassenger(passenger1);
        bus1.addPassenger(passenger2);
        bus1.addPassenger(passenger3);

        riders = bus1.getNumberPassengers();
        if(riders == 1){
            System.out.print("There is 1 passenger on the bus that paid £"
                    + bus1.getCurrentFarePaid()
                    + " and they are "
                    + bus1.getAvgAge()
                    + " years old.");
        }else{
            System.out.print("There are "
                    + riders
                    + " passengers on the bus. They have paid £"
                    + bus1.getCurrentFarePaid()
                    + " in total"
                    + " and they average "
                    + bus1.getAvgAge()
                    + " years old.");
        }
        System.out.println();

        System.out.println("Age Range " + bus1.getAgeRange());

        bus1.getAllRiderDetails(387);
        bus1.getAllRiderDetails(365);


        bus1.removePassenger(387);


        riders = bus1.getNumberPassengers();
        if(riders == 1){
            System.out.print("There is 1 passenger on the bus that paid £"
                    + bus1.getCurrentFarePaid()
                    + " and they are "
                    + bus1.getAvgAge()
                    + " years old.");
        }else{
            System.out.print("There are "
                    + riders
                    + " passengers on the bus. They have paid £"
                    + bus1.getCurrentFarePaid()
                    + " in total"
                    + " and they average "
                    + bus1.getAvgAge()
                    + " years old.");
        }
        System.out.println();
        bus1.getAllRiderDetails(387);

        bus1.removePassenger(387);
        bus1.getAllRiderDetails(387);
        bus1.getAllRiderDetails(365);


        System.out.println("BusId is: \t\t\t\t\t\t"             + company.getBusId(68));
        System.out.println("Number of passengers is: \t\t"  + company.getNumberOfPassengers(68));
        System.out.println("Number of empty seats is: \t\t"   + company.getNumberEmptySeats(68));
        System.out.println("Average age is : \t\t\t\t"      + company.getAvgAge(68));
        System.out.println("Age range is : \t\t\t\t\t"                + company.getAgeRange(68));
        System.out.println("Total fare : \t\t\t\t\t£"                 + company.getTotalFare(68));

        System.out.println("Total fare : \t\t\t\t\t£"                 + company.getTotalFare(68));

    }
}
