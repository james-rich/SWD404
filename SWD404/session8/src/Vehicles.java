abstract class Vehicles {
    protected String reg;
    protected int weight;

    public Vehicles(String regIn, int weightIn){
        this.reg = regIn;
        this.weight = weightIn;
    };

    public String getReg() {
        return reg;
    }

    public int getWeight() {
        return weight;
    }

    public abstract double calculateFees();


}
