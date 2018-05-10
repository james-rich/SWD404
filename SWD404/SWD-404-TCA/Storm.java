public abstract class Storm {

    /*
    This should be protected not private
    private String name;
    private double windSpeed;
    private double temp;
    */

    protected String name;
    protected double windSpeed;
    protected double temp;

    public Storm(String name, double windSpeed, double temp) {
        this.name = name;
        this.windSpeed = windSpeed;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getTemp() {
        return temp;
    }

    public abstract String getClassification();

    public abstract String getAdvice();

}
