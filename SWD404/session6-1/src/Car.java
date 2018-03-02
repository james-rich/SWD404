public class Car {
    private String numberPlate;
    private String colour;
    private String make;
    private String modle;


    public Car(String numberPlate, String colour, String make, String modle) {
        this.numberPlate = numberPlate;
        this.colour = colour;
        this.make = make;
        this.modle = modle;
    }

    public Car(String numberPlate){
        this.numberPlate    = numberPlate;
        this.colour         = null;
        this.make           = null;
        this.modle          = null;
    }

    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }

    public String getModle() {
        return modle;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

}
