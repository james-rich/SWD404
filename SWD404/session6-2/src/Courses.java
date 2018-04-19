public abstract class Courses {
    private String id;
    private String name;

    public Courses(String id, String name) {
        this.id     = id;
        this.name   = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
