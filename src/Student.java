public class Student {
    private String name;
    private int age;
    private int idNo;
    private String address;
    private String course;

    public Student(String name, int age, int idNo, String address, String course) {
        this.name = name;
        this.age = age;
        this.idNo = idNo;
        this.address = address;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getIdNo() {
        return idNo;
    }

    public String getAddress() {
        return address;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID Number: " + idNo);
        System.out.println("Address: " + address);
        System.out.println("Course: " + course);
    }
}
