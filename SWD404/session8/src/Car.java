public class Car extends Vehicles {

    public Car(String regIn, int weigtIn) {
        super(regIn, weigtIn);
    }

    @Override
    public double calculateFees() {
        int fee = (int) (((this.getWeight() - 1590) / 100) / 10);
        return fee + 3;
    }
}
