import javax.swing.text.html.HTMLDocument;
import java.sql.*;

public class PrisonDAO {

    public void addPrison(Prison prison) throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO prison (prison_name, prison_description, prison_capacity, address_id) " +
                "VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, prison.getName());
        stmt.setString(2, prison.getDescription());
        stmt.setInt(3, prison.getCapacity());
        stmt.setInt(4, prison.getAddress_id());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            int prison_id = rs.getInt(1);
            prison.setPrison_id(prison_id);
        }
        else throw new Exception("PrisonDAO.addPrison generated key issue");
    }

    public void removePrison(int id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM prison WHERE prison_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void updateCapacity(int id, int capacity) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "UPDATE person SET capacity = ? WHERE prison_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, capacity);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public static String getPrisonName(int id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM prison WHERE prison_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("prison_name");
        }
        else throw new SQLException();
    }
}
