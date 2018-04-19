public class Dog {
    private String  dogName;
    private String  dogOwnerName;
    private int     dogAge;
    private String  dogGender;
    private String  dogBreed;
    private String  dogNotes;

    public Dog(String dogName, String dogOwnerName, int dogAge, String dogGender, String dogBreed, String dogNotes) {
        this.dogName = dogName;
        this.dogOwnerName = dogOwnerName;
        this.dogAge = dogAge;
        this.dogGender = dogGender;
        this.dogBreed = dogBreed;
        this.dogNotes = dogNotes;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogOwnerName() {
        return dogOwnerName;
    }

    public void setDogOwnerName(String dogOwnerName) {
        this.dogOwnerName = dogOwnerName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogGender() {
        return dogGender;
    }

    public void setDogGender(String dogGender) {
        this.dogGender = dogGender;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogNotes() {
        return dogNotes;
    }

    public void setDogNotes(String dogNotes) {
        this.dogNotes = dogNotes;
    }
}
