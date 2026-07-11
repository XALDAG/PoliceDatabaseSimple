import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CaseOfficerDAO {

    public void addCaseOfficer(CaseOfficer caseOfficer) throws Exception {
        int case_id = caseOfficer.getCase_id();
        int badge_number = caseOfficer.getOfficer_id();
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO case_officer (case_id, badge_number) " +
                "VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, case_id);
        stmt.setInt(2, badge_number);
        stmt.executeUpdate();
    }

    public void deleteCaseOfficer(int case_id, int badge_number) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM case_officer WHERE case_id = ? AND badge_number = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, case_id);
        stmt.setInt(2, badge_number);
        stmt.executeUpdate();
    }

    public int count_officers_by_case(int case_id, ArrayList<Officer> lst) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM case_officer WHERE case_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, case_id);
        ResultSet rs = stmt.executeQuery();
        int count = 0;

        while (rs.next()) {
            count++;
            int badge_number = rs.getInt(2);
            String sql2 = "SELECT * FROM officer WHERE badge_number = ?";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, badge_number);
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                Officer officer = new Officer(rs2.getString("first_name"),
                        rs2.getString("last_name"), rs2.getString("officer_rank"),
                        rs2.getInt("age"), Gender.valueOf(rs2.getString("gender")),
                        rs2.getInt("address_id"));
                officer.setBadge_number(rs2.getInt("badge_number"));
                lst.add(officer);
            }
        }

        return count;

    }
}