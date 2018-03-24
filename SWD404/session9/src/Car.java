public class Car extends Vehicles {

    public Car(String regIn, int weigtIn) {
        super(regIn, weigtIn);
    }

    @Override
    public double calculateFees() {
        double fee = 0;
        if(this.getWeight() > 1590) {
            fee = (double) ((this.getWeight() - 1590) / 100) / 10;
        }
        return fee + 5.00;
    }
}
