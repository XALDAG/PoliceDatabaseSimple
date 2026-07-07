

public class CaseOfficer {
    private int case_id;
    private int officer_id;
    private int department_id;

    public CaseOfficer(int case_id, int officer_id, int department_id) {
        this.case_id = case_id;
        this.officer_id = officer_id;
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getCase_id() {
        return case_id;
    }

    public int getOfficer_id() {
        return officer_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setOfficer_id(int officer_id) {
        this.officer_id = officer_id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }
}
