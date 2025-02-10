public class Student {
    private String name;
    private int age;
    private int idNo;
    private String address;
    private School campus;    // Enrolled campus
    private Course course;    // Enrolled course
    private String semester;  // e.g., "off sem" or "regular sem"

    public Student(String name, int age, int idNo, String address, School campus, Course course, String semester) {
        this.name = name;
        this.age = age;
        this.idNo = idNo;
        this.address = address;
        this.campus = campus;
        this.course = course;
        this.semester = semester;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getIdNo() { return idNo; }
    public String getAddress() { return address; }
    public School getCampus() { return campus; }
    public Course getCourse() { return course; }
    public String getSemester() { return semester; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setIdNo(int idNo) { this.idNo = idNo; }
    public void setAddress(String address) { this.address = address; }
    public void setCampus(School campus) { this.campus = campus; }
    public void setCourse(Course course) { this.course = course; }
    public void setSemester(String semester) { this.semester = semester; }

    public void displayDetails() {
        System.out.println("\n--- Student Enrollment Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID Number: " + idNo);
        System.out.println("Address: " + address);
        if (campus != null) {
            System.out.println("Enrolled Campus: " + campus.getName());
        }
        if (course != null) {
            System.out.println("Enrolled Course: " + course.getName());
        }
        System.out.println("Semester: " + semester);
        System.out.println("Status: Officially Enrolled");
    }
}
