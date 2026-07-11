import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OfficerDAO {

    public void addOfficer(Officer officer) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO officer (first_name, last_name, officer_rank, age, address_id)" +
                "VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, officer.getFirst_name());
        stmt.setString(2, officer.getLast_name());
        stmt.setString(3, officer.getRank());
        stmt.setInt(4, officer.getAge());
        stmt.setInt(5, officer.getAddress_id());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int badge_number = -1;
        if (rs.next()) {
            badge_number = rs.getInt(1);
        }
        officer.setBadge_number(badge_number);
    }

    public void removeOfficerbyBadgeNumber(int badge_number) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        String sql = "DELETE FROM officer WHERE badge_number = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, badge_number);
        stmt.executeUpdate();
    }


    public void updateRank(int badge_number, String rank) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        String sql = "UPDATE officer " +
                "SET officer_rank = ? " +
                "WHERE badge_number = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, rank);
        stmt.setInt(2, badge_number);

        stmt.executeUpdate();
    }

    public void search_by_badge_number(int badge_number) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM officer WHERE badge_number = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, badge_number);

        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while (rs.next()) {
            String last_name = rs.getString("last_name");
            String first_name = rs.getString("first_name");
            String rank = rs.getString("officer_rank");
            int age = rs.getInt("age");

            System.out.println("BADGE NUMBER: " + badge_number + " " + rank + " " + " " +
                    first_name + " " + last_name + " " + age + " " + "YEARS");
            count++;
        }
        System.out.println(count);
    }


    public void filter_by_sex(Gender gender) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM officer WHERE gender = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, gender.name());
        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            int badge_number = rs.getInt("badge_number");
            String first_name = rs.getString("first_name");
            String rank = rs.getString("officer_rank");
            int age = rs.getInt("age");
            String last_name = rs.getString("last_name");

            System.out.println("BADGE NUMBER: " + badge_number + " " + rank + " " + " " +
                    first_name + " " + last_name + " " + age + " " + "YEARS");
            count++;
        }
        System.out.println(count);
    }

    public void filter_older_than(int age) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM officer WHERE age > ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, age);
        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            int badge_number = rs.getInt("badge_number");
            String first_name = rs.getString("first_name");
            String rank = rs.getString("officer_rank");
            String last_name = rs.getString("last_name");

            System.out.println("BADGE NUMBER: " + badge_number + " " + rank + " " + " " +
                    first_name + " " + last_name + " " + age + " " + "YEARS");
            count++;
        }
        System.out.println(count);
    }

    public void in_duty() throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM officer";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            count++;
        }
        System.out.println(count + " Officers in duty");
    }


}