import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main() throws SQLException {
        Connection conn = DataBaseConnection.getConnection();
    }
}
