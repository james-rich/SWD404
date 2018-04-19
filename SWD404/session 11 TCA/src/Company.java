public class Company {
    private Enclosure[] enclosures;

    public Company() {
        this.enclosures = new Enclosure[10];
        for(int i = 0; i <= 9; i++){
            enclosures[i] = new Enclosure(i, 10);
        }
    }

    public boolean addDog(Dog dogIn, int numberOfDaysIn){
        for(int i = 0; i < this.enclosures.length; i++){
            if(this.enclosures[i].getEnclosureOccupant() == null){
                enclosures[i].setEnclosureOccupant(dogIn);
                enclosures[i].setEnclosureDaysBookedIn(numberOfDaysIn);
                return true;
            }
        }
        return false;
    }

    public boolean removeDog(int enclosureNumberIn){
        for(int i = 0; i < enclosures.length; i++){
            if(enclosures[i].getEnclosureOccupant() != null){
                if(enclosures[i].getEnclosureNumber() == (enclosureNumberIn)){
                    enclosures[i] = null;
                    enclosures[i] = new Enclosure(i, 10);
                    return true;
                }
            }
        }
        return false;
    }

    public Dog dogInformation(int enclosureNumberIn){
        for(int i = 0; i < enclosures.length; i++){
            if(enclosures[i] != null){
                if(enclosures[i].getEnclosureNumber() == enclosureNumberIn){
                    return enclosures[i].getEnclosureOccupant();
                }
            }
        }
        return null;
    }

    public double totalPrice(int enclosureNumberIn){
        for(int i = 0; i < enclosures.length; i++) {
            if(enclosures[i].getEnclosureNumber() == enclosureNumberIn) {
                int numberOfDays = enclosures[i].getEnclosureDaysBookedIn();
                double pricePerDay = enclosures[i].getEnclosurePricePerDay();
                return numberOfDays * pricePerDay;
            }
        }
        return 0.00;
    }
}
