public abstract class Persons {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public Persons(String firstName, String lastName, String dateOfBirth) {
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.dateOfBirth    = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

