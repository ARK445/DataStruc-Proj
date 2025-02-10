import java.util.ArrayList;

public class School {
    private String name;
    private String address;
    private ArrayList<Program> programs;
    private ArrayList<Curriculum> curriculums;
    private ArrayList<Course> courses;

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        this.programs = new ArrayList<>();
        this.curriculums = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Getters and setters for name and address
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Methods for managing associated objects
    public void addProgram(Program p) {
        programs.add(p);
    }
    public void addCurriculum(Curriculum c) {
        curriculums.add(c);
    }
    public void addCourse(Course c) {
        courses.add(c);
    }
    public ArrayList<Program> getPrograms() {
        return programs;
    }
    public ArrayList<Curriculum> getCurriculums() {
        return curriculums;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void displayDetails() {
        System.out.println("\n--- Campus Details ---");
        System.out.println("Campus Name: " + name);
        System.out.println("Campus Address: " + address);
        System.out.println("Programs: " + programs.size() + ", Curriculums: " + curriculums.size() + ", Courses: " + courses.size());
    }
}
