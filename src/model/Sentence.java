import java.time.LocalDate;


public class Sentence {
    private int sentence_id;
    private int case_id;
    private int prison_id;
    private int years;
    private LocalDate start_date;
    private LocalDate end_date;

    public Sentence(int case_id, int prison_id, int years,
                    LocalDate start_date, LocalDate end_date) {

        this.case_id = case_id;
        this.prison_id = prison_id;
        this.years = years;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getPrison_id() {
        return prison_id;
    }

    public int getCase_id() {
        return case_id;
    }

    public int getSentence_id() {
        return sentence_id;
    }

    public int getYears() {
        return years;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setPrison_id(int prison_id) {
        this.prison_id = prison_id;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setYears(int years) {
        this.years = years;
    }

}
