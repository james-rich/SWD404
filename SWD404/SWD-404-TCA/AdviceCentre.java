public class AdviceCentre {
    private Storm[] storms = new Storm[10];
    private Tornado tornado;
    private Hurricane hurricane;
    private Blizzard blizzard;

    public boolean addStorm(String nameIn, double windSpeedIn, double tempIn, String typeIn){
        for(int i =0; i < storms.length; i++){
            if(storms[i] == null){
                if(typeIn.equals("Tornado")){
                    tornado = new Tornado(nameIn, windSpeedIn, tempIn);
                    storms[i] = tornado;
                    return true;
                }else if(typeIn.equals("Hurricane")){
                    hurricane = new Hurricane(nameIn, windSpeedIn, tempIn);
                    storms[i] = hurricane;
                    return true;
                }else if(typeIn.equals("Blizzard")){
                    blizzard = new Blizzard(nameIn, windSpeedIn, tempIn);
                    storms[i] = blizzard;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeStorm(String stormName){
        for(int i = 0; i < storms.length; i++){
            if(storms[i] != null) {
                if (storms[i].getName().equals(stormName)){
                    storms[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Storm getStorm(String stormName){
        for(int i = 0; i < storms.length; i++){
            if(storms[i] != null) {
                if (storms[i].getName().equals(stormName)){
                    return storms[i];
                }
            }
        }
        return null;
    }

}
