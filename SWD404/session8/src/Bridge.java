public class Bridge {
    private Vehicles[] vehicles;

    public Bridge() {
        this.vehicles = new Vehicles[20];
    }

    public int calcTotalWeight(){
        int totalWeight = 0;
        for(int i = 0; i < vehicles.length; i++){
            totalWeight += vehicles[i].getWeight();
        }
        return totalWeight;
    }

    public String addVehicles(Vehicles vehiclesIn){
        for(int i = 0; i < vehicles.length; i++){
            if(vehicles[i] == null){
                if((calcTotalWeight() + vehiclesIn.getWeight()) < 30000){
                    vehicles[i] = vehiclesIn;
                    return "Added";
                }else{
                    return "Bridge weight cap!";
                }
            }
            return "Too many cars!";
        }
        return "Error!";
    }

    public boolean removeVehicles(String regIn){
        for(int i = 0; i < vehicles.length; i++){
            if(vehicles[i] != null){
                if(vehicles[i].getReg().equals(regIn)){
                    vehicles[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
