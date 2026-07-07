


public class Person {
    private int person_id;
    private int address_id;
    private String first_name;
    private String last_name;
    private int age;
    private Gender gender;

    public Person(String first_name, String last_name,
                  int age, Gender gender) {
        this.first_name = first_name.toUpperCase();
        this.last_name = last_name.toUpperCase();
        this.age = age;
        this.gender = gender;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return String.format("""
                FIRST NAME: %s
                LAST NAME: %s
                AGE: %d
                GENDER: %s
                """, first_name, last_name, age, gender);
    }
}
