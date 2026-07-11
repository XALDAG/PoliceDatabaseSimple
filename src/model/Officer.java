

public class Officer {
    private int address_id;
    private int badge_number;
    private String first_name;
    private String last_name;
    private String rank;
    private int age;
    private Gender gender;

    public Officer(String first_name,
                   String last_name, String rank, int age, Gender gender, int address_id) throws IllegalArgumentException{

        this.first_name = first_name.toUpperCase();
        this.last_name = last_name.toUpperCase();
        this.rank = rank.toUpperCase();
        this.age = age;
        this.address_id = address_id;
        this.gender = gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getAddress_id() {
        return address_id;
    }

    public int getBadge_number() {
        return badge_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getRank() {
        return rank;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setBadge_number(int badge_number) {
        this.badge_number = badge_number;
    }

    public void setRank(String new_rank) {
        this.rank = new_rank.toUpperCase();
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name.toUpperCase();
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name.toUpperCase();
    }


    public String toString() {
        return rank + " " + first_name + " " + last_name +
                " " + badge_number;
    }
}
