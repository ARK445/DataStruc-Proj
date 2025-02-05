public class School {
    private String name;
    private String address;

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    public void displayDetails() {
        System.out.println("\n--- School Details ---");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
