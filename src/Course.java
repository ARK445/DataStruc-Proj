public class Course {
    private String name;
    private int credits;
    // Association with Program
    private Program program;

    // Constructor without program association
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.program = null;
    }

    // Constructor with program association
    public Course(String name, int credits, Program program) {
        this.name = name;
        this.credits = credits;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public Program getProgram() {
        return program;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void displayDetails() {
        System.out.println("\n--- Course Details ---");
        System.out.println("Name: " + name);
        System.out.println("Credits: " + credits);
        if (program != null) {
            System.out.println("Program: " + program.getName());
            System.out.println("Program Description: " + program.getDescription());
        } else {
            System.out.println("No program associated with this course.");
        }
    }
}
