import java.util.Scanner;

public class Main {

    public static String getString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }



    public static void main(String[] args) {

        Company company = new Company();


        int state = 1;
        while(state == 1) {
            System.out.println("Please select one of the following options");

            System.out.println("A - Add a Dog");
            System.out.println("B - Remove a Dog");
            System.out.println("C - View a Dogs Information");
            System.out.println("X - Quit");

            String userInput = getString();

            if (userInput.equals("X") || userInput.equals("xx")) {
                state = 0;
            }

            if (userInput.equals("A")) {
                System.out.print("Please enter the Owners Name:");
                String ownersName = getString();
                System.out.println();
                System.out.print("Please enter the Dog's name:");
                String dogsName = getString();
                System.out.println();
                System.out.print("Please enter Dog's age:");
                int dogsAge = getInt();
                System.out.println();
                System.out.print("Please enter Dog's gender:");
                String dogsGender = getString();
                System.out.println();
                System.out.print("Please enter Dog's breed:");
                String dogsBreed = getString();
                System.out.println();
                System.out.print("Please enter any notes:");
                String dogsNotes = getString();
                System.out.println();
                System.out.print("Number Of Day's the " + dogsName + " Will be staying:");
                int dogStayInDays = getInt();
                System.out.println();
                Dog dog = new Dog(dogsName, ownersName,dogsAge, dogsGender, dogsBreed,dogsNotes);
                boolean dogAdded = company.addDog(dog, dogStayInDays);
                if (dogAdded) {
                    System.out.println("dog added");
                }
            }

            if (userInput.equals("B")) {
                System.out.print("What dog would you like to evict!");
                int result = getInt();
                boolean dogRemoved = company.removeDog(result);
                System.out.println("Was the dog removed = " + dogRemoved);
            }

            if (userInput.equals("C")) {
                System.out.print("What dog would you like to see information for!");
                int result = getInt();
                Dog dogInformation = company.dogInformation(result);
                if (dogInformation != null) {
                    System.out.println("Information for Enclosure: " + result);
                    System.out.println("Dog Name:\t\t" + dogInformation.getDogName());
                    System.out.println("Owner Name:\t\t" + dogInformation.getDogOwnerName());
                    System.out.println("Dog Age:\t\t" + dogInformation.getDogAge());
                    System.out.println("Dog Breed:\t\t" + dogInformation.getDogBreed());
                    System.out.println("Dog Gender:\t\t" + dogInformation.getDogGender());
                    System.out.println("Dog Notes:\t\t" + dogInformation.getDogNotes());
                } else {
                    System.out.println("No Dog found here!");
                }
            }
        }
    }
}
