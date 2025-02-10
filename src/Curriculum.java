public class Curriculum {
    private String title;
    private String version;

    public Curriculum(String title, String version) {
        this.title = title;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }
    public String getVersion() {
        return version;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public void displayDetails() {
        System.out.println("\n--- Curriculum Details ---");
        System.out.println("Title: " + title);
        System.out.println("Version: " + version);
    }
}
