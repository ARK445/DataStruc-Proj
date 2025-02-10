public class Program {
    private String name;
    private String description;

    public Program(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void displayDetails() {
        System.out.println("\n--- Program Details ---");
        System.out.println("Program Name: " + name);
        System.out.println("Description: " + description);
    }
}
