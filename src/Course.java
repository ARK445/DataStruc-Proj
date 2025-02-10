public class Course {
    private String name;
    private int credits;
    // (Optionally, a course could be linked to a program—but here it is kept simple)

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void displayDetails() {
        System.out.println("\n--- Course Details ---");
        System.out.println("Course Name: " + name);
        System.out.println("Credits: " + credits);
    }
}
