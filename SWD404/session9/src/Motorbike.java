public class Motorbike extends Vehicles {

    public Motorbike(String regIn, int weightIn) {
        super(regIn, weightIn);
    }

    @Override
    public double calculateFees() {
        return 3;
    }
}
