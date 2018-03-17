public abstract class Vehicles {
    private String reg;
    private int weight;

    public Vehicles(String in, int regIn){};

    public String getReg() {
        return reg;
    }

    public int getWeight() {
        return weight;
    }

    public abstract double calculateFees();


}
