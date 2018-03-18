public class Bridge {
    private Vehicles[] vehicles = new Vehicles[20];

    public int calcTotalWeight(){
        int totalWeight = 0;
        for(int i = 0; i < vehicles.length; i++){
            if(vehicles[i] != null){
                System.out.println(vehicles[i].getReg());
                System.out.println(vehicles[i].getWeight());
                totalWeight += vehicles[i].getWeight();
            }
        }
        return totalWeight;
    }

    public double addVehicles(Vehicles vehiclesIn){
        for(int i = 0; i < vehicles.length; i++) {
            if(vehicles[i] == null) {
                vehicles[i] = vehiclesIn;
                return vehicles[i].calculateFees();

            }
        }
        return 0;
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
