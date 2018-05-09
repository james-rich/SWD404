public class Hurricane extends Storm{

    public Hurricane(String name, double windSpeed, double temp) {
        super(name, windSpeed, temp);
    }

    @Override
    public String getClassification() {
        String criteria;
        if(this.getWindSpeed() >= 74 && this.getWindSpeed() <= 110){
            criteria = "Dangerous";
        }else if(this.getWindSpeed() >= 111 && this.getWindSpeed() <= 229){
            criteria = "Devastating";
        }else if(this.getWindSpeed() >= 130){
            criteria = "Catastrophic";
        }else {
            criteria = "Tropical Storm/Depression";
        }
        return criteria;
    }

    @Override
    public String getAdvice() {
        if(getClassification().equals("Dangerous")){
            return "Close storm shutter, stay away from windows";
        }else if(getClassification().equals("Devastating")){
            return "Coastal regions are encouraged to evacuate";
        }else if (getClassification().equals("Catastrophic")){
            return "Evacuate";
        }else {
            return "No action required";
        }
    }
}
