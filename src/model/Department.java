

public class Department {
    private int department_id;
    private String name;
    private int address_id;

    public Department(String name, int address_id) {
        this.name = name.toUpperCase();
        this.address_id = address_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
