public class Bridge {
    private Vehicles[] vehicles = new Vehicles[20];
    private int maxWeight = 30000;


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

    public boolean addVehicles(Vehicles vehiclesIn){
        if(maxWeight >= calcTotalWeight() + vehiclesIn.getWeight()) {
            for (int i = 0; i < vehicles.length; i++) {
                if (vehicles[i] == null) {
                    vehicles[i] = vehiclesIn;
                    return true;

                }
            }
        }
        return false;
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
