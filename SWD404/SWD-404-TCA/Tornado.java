public class Tornado extends Storm {

    public Tornado(String name, double windSpeed, double temp) {
        super(name, windSpeed, temp);
    }

    @Override
    public String getClassification() {
        String criteria;
        if(this.getWindSpeed() >= 40 && this.getWindSpeed() <= 112){
            criteria = "Weak";
        }else if(this.getWindSpeed() >= 113 && this.getWindSpeed() <= 206){
            criteria = "Strong";
        }else if(this.getWindSpeed() >= 40 && this.getWindSpeed() <= 112){
            criteria = "Violent";
        }else {
            criteria = "Unclassified";
        }
        return criteria;
    }

    @Override
    public String getAdvice() {
        if(getClassification().equals("Weak")){
            return "Find safe room/shelter, shield yourself from debris";
        }else if(getClassification().equals("Strong") || getClassification().equals("Violent")){
            return "Find underground shelter, crouch near to the floor covering your head with your hands";
        }else {
            return "There is no need to panic";
        }
    }
}
