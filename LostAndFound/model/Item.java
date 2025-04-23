package model;

public class Item implements ItemInterface {
    private String name;
    private String description;
    private String location;
    private String contact;
    private String status;

    public Item(String name, String description, String location, String contact, String status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.status = status;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public String getLocation() { return location; }

    @Override
    public String getContact() { return contact; }

    @Override
    public String getStatus() { return status; }

    @Override
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("| %-15s | %-25s | %-20s | %-15s | %-10s |",
            name, description, location, contact, status);
    }
}
