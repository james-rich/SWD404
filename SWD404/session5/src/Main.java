public class Main {
    public static void main(String[] args)
    {
        Car car1 = new Car();
        car1.setEngineSize(1.8);
        car1.setMpg(36.2);
        car1.setNumberOfDoors(4);
        car1.setNumberOfSeats(5);
        car1.setFuelLevel(100);
        car1.setFuelCapacityGallons(60);

        car1.driveVehicle(36.2);


        car1.addPassanger(2);

        car1.addPassanger(4);


        Bus bus1 = new Bus(1.7);
        bus1.setEngineSize(1.8);
        bus1.setMpg(21.1);
        bus1.setNumberOfDoors(4);
        bus1.setNumberOfSeats(30);
        bus1.setFuelLevel(30);
        bus1.setFuelCapacityGallons(120);

        bus1.driveVehicle(10);

        Lorry lorry1 = new Lorry();
        lorry1.setEngineSize(1.8);
        lorry1.setMpg(12.9);
        lorry1.setNumberOfDoors(4);
        lorry1.setNumberOfSeats(5);
        lorry1.setFuelLevel(100);
        lorry1.setFuelCapacityGallons(200);

        lorry1.driveVehicle(12.9);

        lorry1.addPassanger(1);


    }


}
