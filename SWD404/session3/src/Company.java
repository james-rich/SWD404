public class Company {
    private String companyName;
    private Bus[] buses;

    public Company(String companyName) {
        this.companyName = companyName;
        this.buses = new Bus[5];
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Bus[] getBuses() {
        return buses;
    }

    public void setBuses(Bus[] buses) {
        this.buses = buses;
    }

    public boolean addBus(Bus newBus){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] == null){
                buses[i] = newBus;
                return true;
            }
        }
        return false;
    }


    public int getBusId(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null) {
                if (buses[i].getBusId() == busId) {
                    return this.buses[i].getBusId();
                }
            }
        }
        return 0;
    }

    public int getNumberOfPassengers(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null) {
                if (buses[i].getBusId() == busId) {
                    return this.buses[i].getNumberPassengers();
                }
            }
        }
        return 0;
    }

    public int getNumberEmptySeats(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null){
                if(buses[i].getBusId() == busId) {
                    return this.buses[i].getNumberOfSeats() - this.buses[i].getNumberPassengers();
                }
            }
        }
        return 0;
    }

    public double getAvgAge(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null) {
                if (buses[i].getBusId() == busId) {
                    return this.buses[i].getAvgAge();
                }
            }
        }
        return 0;
    }

    public int getAgeRange(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null) {
                if (buses[i].getBusId() == busId) {
                    return this.buses[i].getAgeRange();
                }
            }
        }
        return 0;
    }

    public double getTotalFare(int busId){
        for(int i = 0; i < buses.length; i++){
            if(buses[i] != null) {
                if (buses[i].getBusId() == busId) {
                    return this.buses[i].getCurrentFarePaid();
                }
            }
        }
        return 0;
    }
}
