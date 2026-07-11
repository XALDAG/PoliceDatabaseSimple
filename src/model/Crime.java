

public class Crime {
    private int crime_id;
    private String name;
    private String category;
    private int address_id;

    public Crime(String name, String category) {
        this.name = name.toUpperCase();
        this.category = category.toUpperCase();
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
