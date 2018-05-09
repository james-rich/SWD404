public class Blizzard extends Storm{

    public Blizzard(String name, double windSpeed, double temp) {
        super(name, windSpeed, temp);
    }

    @Override
    public String getClassification() {
        String criteria;
        if(this.getWindSpeed() > 35 && this.getWindSpeed() <= 44){
            criteria = "Blizzard";
        }else if(this.getWindSpeed() >= 45 && this.getTemp() < -12){
            criteria = "Severe Blizzard";
        }else{
            criteria = "Snow storm";
        }
        return criteria;
    }

    @Override
    public String getAdvice() {
        if(getClassification().equals("Blizzard")){
            return "Keep warm, Do not travel unless absolutely essential.";
        }else if(getClassification().equals("Severe Blizzard")){
            return "Keep Warm, avoid all travel.";
        }else if(getClassification().equals("Snow storm")){
            return "Take care, avoid travel if possible";
        }
        return "Error, storm classification not found!";
    }
}
