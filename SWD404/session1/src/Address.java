import java.util.Scanner;


class StudentClass{
    int rollNumber;
    String studentName;
    Address studentAddress;
    StudentClass(int rollNumberIn, String studentNameIn, Address studentAddressIn){
        this.rollNumber = rollNumberIn;
        this.studentName = studentNameIn;
        this.studentAddress = studentAddressIn;
    }

    public static void main(String[] args){

        Scanner dataIn = new Scanner(System.in);

        Address address1 = new Address();
        System.out.print("Street Number:");
        address1.streetNumber = dataIn.nextInt();

        System.out.print("Street Name:");
        dataIn.nextLine();
        address1.streetName = dataIn.nextLine();

        System.out.print("City:");
        address1.city = dataIn.nextLine();

        System.out.print("County:");
        address1.county = dataIn.nextLine();

        System.out.print("Country:");
        address1.country = dataIn.nextLine();

        StudentClass student1 = new StudentClass(01,"James", address1);

        System.out.println(student1.rollNumber);
        System.out.println(student1.studentName);
        System.out.println(student1.studentAddress.streetNumber);
        System.out.println(student1.studentAddress.streetName);
        System.out.println(student1.studentAddress.city);
        System.out.println(student1.studentAddress.county);
        System.out.println(student1.studentAddress.country);
    }
}

class Address {
    int streetNumber;
    String streetName;
    String city;
    String county;
    String country;

    Address(){
        this.streetNumber = 0;
        this.streetName = "First Line";
        this.city= "City";
        this.county = "County";
        this.country = "Country";
    }

    Address(int streetNumberIn, String streetNameIn, String cityIn, String countyIn, String countryIn){
        this.streetNumber = streetNumberIn;
        this.streetName = streetNameIn;
        this.city= cityIn;
        this.county = countyIn;
        this.country = countryIn;
    }
}