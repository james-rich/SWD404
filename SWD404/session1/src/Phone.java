public class Phone {
    public String make;
    public String model;
    public int batteryLevel;
    public int signalStrength;
    public String phoneNumber;
    public boolean inCall;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isInCall() {
        return inCall;
    }

    public void setInCall(boolean inCall) {
        this.inCall = inCall;
    }

    public Phone(String make, String model, int batteryLevel, int signalStrength, String phoneNumber, boolean inCall) {
        this.make = make;
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.signalStrength = signalStrength;
        this.phoneNumber = phoneNumber;
        this.inCall = inCall;
    }

    public void makeCall(){
        if(!inCall && signalStrength > 0 && batteryLevel > 0) {
            batteryLevel--;
            inCall = true;
        }else{
            batteryLevel--;
            System.out.println("Can't make a call at this time!");
        }
        if(batteryLevel <= 0){
            System.out.println("Battery low powering down!");
            hangUp();
        }
    }

    public void receiveCall(){
        if(!inCall && signalStrength > 0 && batteryLevel > 0){
            batteryLevel--;
            inCall = true;
        }else{
            batteryLevel--;
            System.out.println("Can't receive a call at this time!");
        }
        if(batteryLevel <= 0){
            System.out.println("Battery low powering down!");
            hangUp();
        }
    }

    public void hangUp(){
        batteryLevel--;
        inCall = false;
    }

    public void chargePhone(){
        batteryLevel = 100;
    }

    public void signalStrength(int signalIn){
        signalStrength = signalIn;
        batteryLevel--;
        if(batteryLevel <= 0){
            System.out.println("Battery low powering down!");
            hangUp();
        }

    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("Nokia", "402", 8, 22, "07482130251", false);

        System.out.println("Make:\t\t" + phone1.make);
        System.out.println("Model:\t\t" + phone1.model);
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println("Number:\t\t" + phone1.phoneNumber);
        System.out.println();

        phone1.makeCall();
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println();

        phone1.receiveCall();
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println();

        phone1.hangUp();

        phone1.signalStrength(0);
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println();

        phone1.makeCall();
        System.out.println();

        phone1.signalStrength(10);

        phone1.makeCall();
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println();

        phone1.hangUp();

        phone1.receiveCall();

        phone1.chargePhone();
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
        System.out.println();

        phone1.receiveCall();
        System.out.println("Battery:\t" + phone1.batteryLevel);
        System.out.println("Signal:\t\t" + phone1.signalStrength);
        System.out.println("In Call: \t" + phone1.inCall);
    }
}
