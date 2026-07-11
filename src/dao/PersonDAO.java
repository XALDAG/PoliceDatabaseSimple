import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {

    public void addPerson(Person person) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO person (first_name, last_name, age, gender, address_id) " +
                "VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, person.getFirst_name());
        stmt.setString(2, person.getLast_name());
        stmt.setInt(3, person.getAge());
        stmt.setString(4, person.getGender().name());
        stmt.setInt(5, person.getAddress_id());
        stmt.executeUpdate();
    }

    public void removePerson(int id) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "DELETE FROM person WHERE person_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void update_age(int id, int age) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "UPDATE person SET age = ? WHERE person_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, age);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

}
