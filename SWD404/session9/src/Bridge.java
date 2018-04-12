import java.util.ArrayList;

public class Bridge {
    private ArrayList<Vehicles> vehicles = new ArrayList<>();

    public int calcTotalWeight(){
        int totalWeight = 0;
        for(Vehicles i : vehicles){
            if(i != null){
                System.out.println(i.getReg());
                System.out.println(i.getWeight());
                totalWeight += i.getWeight();
            }
        }
        return totalWeight;
    }

    public double addVehicles(Vehicles vehiclesIn){
        vehicles.add(vehiclesIn);
        return vehiclesIn.calculateFees();
    }

    public boolean removeVehicles(String regIn){
            for(Vehicles i : vehicles){
                if(i.getReg().equals(regIn)){
                    vehicles.remove(i);
                    return true;
                }
            }
        return false;
    }
}
