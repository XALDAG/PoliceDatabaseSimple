import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDateTime;

public class AddressDAO {
    public void addAddress(Address address) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        String sql = "INSERT INTO address (address_line1, address_line2," +
                "city, state_province, postal_code, country," +
                "latitude, longitude, created_at, updated_at)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";


        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, address.getAddr1());
        stmt.setString(2, address.getAddr2());
        stmt.setString(3, address.getCity());
        stmt.setString(4, address.getStateProvince());
        stmt.setString(5, address.getPostalCode());
        stmt.setString(6, address.getCountry());
        stmt.setDouble(7, address.getLat());
        stmt.setDouble(8, address.getLng());
        stmt.setObject(9, address.getCreatedAt());
        stmt.setObject(10, address.getUpdatedAt());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int address_id = -1;
        if (rs.next()) {
            address_id = rs.getInt(1);
        }
        address.setAddressId(address_id);
    }


    public void removeAddressbyID(int address_id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        String sql = "DELETE FROM address WHERE address_id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, address_id);
        stmt.executeUpdate();
    }

    public void changeAddr1(int address_id, String addr) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        String sql = "UPDATE address " +
                "SET address_line1 = ? " +
                "WHERE address_id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, addr);
        stmt.setInt(2, address_id);

        stmt.executeUpdate();
    }

}
