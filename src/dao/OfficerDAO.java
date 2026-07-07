import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfficerDAO {

    public void add_officer(Officer officer, Address address) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO officer (first_name, last_name, badge_number)" +
                "VALUES ()";
        PreparedStatement stmt = connection.prepareStatement(sql);
    }

}