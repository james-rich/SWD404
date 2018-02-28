public class Lorry extends Vehicle{

    @Override
    public boolean addPassanger(int newPassengers) {
        System.out.println("Sorry a lorry is not a bus!");
        return false;
    }
}
