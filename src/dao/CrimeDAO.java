import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrimeDAO {

    public void addCrime(Crime crime) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO crime (crime_name, crime_category, address_id) " +
                "VALUES (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,crime.getName());
        stmt.setString(2, crime.getCategory());
        stmt.setInt(3, crime.getAddress_id());
        stmt.executeUpdate();
    }

    public void removeCrime(int id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM crime WHERE crime_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}
