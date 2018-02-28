import java.util.Scanner;

public class Main {

    public static String getString(){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        return input;
    }

    public static void main(String[] args){
        new Gui().MakeGui();


        int state = 1;
        String result;
        Carpark carpark1 = new Carpark();
        Car car1 = new Car("adfga");
        carpark1.addCar(car1);




        while(state == 1) {
            System.out.println("Please seclect one of the following options:" +
                    "\nA - Add a car" +
                    "\nB - Remove a car" +
                    "\nC - View number of free spaces" +
                    "\nX - Quit");

            result = getString();

            switch (result){
                case "A":
                    System.out.println("Adding a car...");
                    System.out.print("please enter the number plate to add :");
                    result = getString();
                    Car addCar = new Car(result);
                    boolean carAdded = carpark1.addCar(addCar);
                    if(carAdded){
                        System.out.println("Car " + addCar.getNumberPlate() + " has been added!");
                    }else{
                        System.out.println("There are no spaces!");
                    }
                    break;
                case "B":
                    System.out.println("Removing a car...");
                    System.out.print("please enter the number plate to remove :");
                    result = getString();
                    Car removeCar = new Car(result);
                    boolean carRemoved = carpark1.removeCar(removeCar);
                    if(carRemoved){
                        System.out.println("Car " + removeCar.getNumberPlate() + " has been removed!");
                    }else{
                        System.out.println("This car is not in the car park!");
                    }
                    break;
                case "C":
                    System.out.println("Getting number of spaces...");
                    int numOfCars = carpark1.getNumCars();
                    int numOfSpaces = carpark1.getNumberOfSpaces() - numOfCars;
                    System.out.println("There are " + numOfCars + " and " + numOfSpaces + " spaces left.");
                    break;
                case "X":
                    System.out.println("Shutting down...");
                    state = 0;
                    break;
                default:
                    System.out.println("Sorry this option is not available!");
                    break;
            }
        }
    }

}
