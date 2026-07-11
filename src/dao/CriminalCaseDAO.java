import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class CriminalCaseDAO {

    public void addCriminalCase(CriminalCase criminalCase) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO criminal_case (person_id, crime_id, arrest_date, court_date) VALUES " +
                "(?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, criminalCase.getPerson_id());
        stmt.setInt(2, criminalCase.getCrime_id());
        stmt.setObject(3, criminalCase.getArrest_date());
        stmt.setObject(4, criminalCase.getCourt_date());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int case_id = rs.getInt(1);
            criminalCase.setCase_id(case_id);
        }
        else throw new SQLException();
    }

    public void removeCriminalCase(int id) throws Exception{
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM criminal_case WHERE case_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public int count_cases(int id) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM criminal_case";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }

    public int crimes_by_id(int person_id) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM criminal_case WHERE person_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, person_id);
        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while(rs.next()) {
            count++;
            int crime_id = rs.getInt("crime_id");
            String sql2 = "SELECT * FROM crime WHERE crime_id = ?";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, crime_id);
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                System.out.println(rs2.getString("crime_name") +
                        " \n Category: " + rs2.getString("crime_category"));
            }
        }
        return count;
    }
}