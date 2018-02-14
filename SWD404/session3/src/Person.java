public class Person {
    private String name;
    private int personId;
    private int age;
    private double farePaid;

    public Person(String name, int personId, int age, double fairPaid) {
        this.name = name;
        this.personId = personId;
        this.age = age;
        this.farePaid = fairPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFarePaid() {
        return farePaid;
    }

    public void setFairPaid(double fairPaid) {
        this.farePaid = fairPaid;
    }

}
