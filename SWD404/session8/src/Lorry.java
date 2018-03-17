public class Lorry extends Vehicles {

    public Lorry(String regIn, int weigtIn) {
        super(regIn, weigtIn);
    }

    @Override
    public double calculateFees() {
        return this.getWeight() > 8000 ? 15:10;
    }
}
