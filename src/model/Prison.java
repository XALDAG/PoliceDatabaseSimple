

public class Prison {
    private int prison_id;
    private int address_id;
    private String name;

    private String description;
    private int capacity;

    public Prison (String name,
                   String description,
                   int capacity) throws IllegalArgumentException{

        if (capacity < 0) throw new
                IllegalArgumentException("CAPACITY OF THE PRISON MUST BE GREATER THAN 0");
        this.name = name.toUpperCase();
        this.description = description.toUpperCase();
        this.capacity = capacity;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setPrison_id(int prison_id) {
        this.prison_id = prison_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public int getPrison_id() {
        return prison_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "CAPACITY: " + capacity + "\n" +
                description + "\n";
    }

}
