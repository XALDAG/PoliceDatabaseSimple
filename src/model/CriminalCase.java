import java.time.LocalDate;

public class CriminalCase {
    private int case_id;
    private int person_id;
    private int crime_id;
    private LocalDate arrest_date;
    private LocalDate court_date;

    public CriminalCase(int person_id, int crime_id,
                        LocalDate arrest_date, LocalDate court_date) {

        this.person_id = person_id;
        this.crime_id = crime_id;
        this.arrest_date = arrest_date;
        this.court_date = court_date;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }


    public int getCase_id() {
        return case_id;
    }


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    public LocalDate getArrest_date() {
        return arrest_date;
    }

    public void setArrest_date(LocalDate arrest_date) {
        this.arrest_date = arrest_date;
    }

    public LocalDate getCourt_date() {
        return court_date;
    }

    public void setCourt_date(LocalDate court_date) {
        this.court_date = court_date;
    }
}
