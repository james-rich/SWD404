public class Bus {
    private int busId;
    private int numberOfSeats;
    private Person[] passengers;
    private int numberPassengers;

    public Bus(int busId, int numberOfSeats) {
        this.busId = busId;
        this.numberOfSeats = numberOfSeats;
        this.passengers = new Person[15];
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

    public boolean addPassenger(Person newRider) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                this.passengers[i] = newRider;
                this.numberPassengers += 1;
                return true;
            }
        }
        return false;
    }

    public boolean removePassenger(int riderId){
        for(int i = 0; i < passengers.length; i++)
        {
            if(this.passengers[i] != null) {
                if (passengers[i].getPersonId() == riderId) {
                    passengers[i] = null;
                    this.numberPassengers -= 1;
                    return true;
                }
            }
        }
        System.out.println("No passenger with the ID of " + riderId + " to remove.");
        System.out.println();
        return false;
    }

    public boolean getAllRiderDetails(int riderId) {
        for (int i = 0; i < passengers.length; i++) {
            if(this.passengers[i] != null) {
                if(this.passengers[i].getPersonId() == riderId) {
                    System.out.println("Getting passenger information...");
                    System.out.println("Rider ID: \t\t\t" + this.passengers[i].getPersonId());
                    System.out.println("Rider Name: \t\t" + this.passengers[i].getName());
                    System.out.println("Rider Age: \t\t\t" + this.passengers[i].getAge());
                    System.out.println("Rider Fair: \t\t" + this.passengers[i].getFarePaid());
                    System.out.println("End of data");
                    System.out.println();
                    return true;
                }
            }
        }
     return false;
    }

    public double getCurrentFarePaid(){
        double totalFare = 0;
        for(int i = 0; i < passengers.length; i++){
            if(this.passengers[i] != null){
                totalFare += this.passengers[i].getFarePaid();
            }
        }
        return totalFare;
    }

    public double getAvgAge(){
        double avgAge = 0;
        int passengersCount = getNumberPassengers();
        for(int i = 0; i < passengers.length; i++){
            if(passengers[i] != null){
                avgAge += passengers[i].getAge();
            }
        }
        return avgAge / passengersCount;
    }

    public int getAgeRange(){
        int ageRange;
        int minAge = 999;
        int maxAge = 0;
        for(int i = 0; i < passengers.length; i++){
            if(passengers[i] != null) {
                maxAge = passengers[i].getAge() >= maxAge ? passengers[i].getAge() : maxAge;
                minAge = passengers[i].getAge() <= minAge ? passengers[i].getAge() : minAge;
            }
        }
        ageRange = maxAge - minAge;
        return ageRange;
    }
}

