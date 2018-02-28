public class Bus extends Vehicle{
    private double passengerChargeMile;

    public Bus(double passancerChargeMile){
        this.passengerChargeMile = passancerChargeMile;
    }

    public double getPassancerChargeMile() {
        return passengerChargeMile;
    }

    public void setPassancerChargeMile(double passancerChargeMile) {
        this.passengerChargeMile = passancerChargeMile;
    }
}
