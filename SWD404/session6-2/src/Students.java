public class Students extends Persons{

    private String  id;
    private Courses course;

    public Students(String firstName, String lastName, String dateOfBirth, String id, Courses course) {
        super(firstName, lastName, dateOfBirth);
        this.id = id;
        this.course = course;
    }


}
