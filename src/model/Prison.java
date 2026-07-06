

public class Prison {
    private String name;
    private String location;
    private String description;
    private int capacity;

    public Prison (String name,
                   String location,
                   String description,
                   int capacity) throws IllegalArgumentException{

        if (capacity < 0) throw new
                IllegalArgumentException("CAPACITY OF THE PRISON MUST BE GREATER THAN 0");
        this.name = name.toUpperCase();
        this.location = location.toUpperCase();
        this.description = description.toUpperCase();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public void setCapacity(int new_cap) {
        this.capacity = new_cap;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "LOCATION: " + location + "\n" +
                "CAPACITY: " + capacity + "\n" +
                description + "\n";
    }

}
