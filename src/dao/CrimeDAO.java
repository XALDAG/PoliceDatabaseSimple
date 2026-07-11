import java.sql.*;

public class CrimeDAO {

    public void addCrime(Crime crime) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO crime (crime_name, crime_category) " +
                "VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,crime.getName());
        stmt.setString(2, crime.getCategory());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int crime_id = rs.getInt(1);
            crime.setCrime_id(crime_id);
        }
        else throw new SQLException();
    }

    public void removeCrime(int id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM crime WHERE crime_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}
