

public class Officer {
    final private int badge_number;
    private String first_name;
    private String last_name;
    private String rank;

    public Officer(int badge_number, String first_name,
                   String last_name, String rank) throws IllegalArgumentException{

        if (badge_number < 0) throw new IllegalArgumentException("BADGE NUMBER MUST BE GREATER THAN 0");
        this.badge_number = badge_number;
        this.first_name = first_name.toUpperCase();
        this.last_name = last_name.toUpperCase();
        this.rank = rank.toUpperCase();
    }

    public int getBadge_number() {
        return badge_number;
    }

    public String setFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getRank() {
        return rank;
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
