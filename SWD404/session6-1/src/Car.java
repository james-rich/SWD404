public class Car {
    private String numberPlate;
    private String colour;
    private String make;
    private String model;


    public Car(String numberPlate, String colour, String make, String model) {
        this.numberPlate    = numberPlate;
        this.colour         = colour;
        this.make           = make;
        this.model          = model;
    }

    public Car(String numberPlate){
        this.numberPlate    = numberPlate;
        this.colour         = null;
        this.make           = null;
        this.model          = null;
    }

    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

}
