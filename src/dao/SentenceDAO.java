import java.sql.*;

public class SentenceDAO {

    public void addSentence(Sentence sentence) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "INSERT INTO sentence (case_id, prison_id, years, start_date, end_date) " +
                "VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, sentence.getCase_id());
        stmt.setInt(2, sentence.getPrison_id());
        stmt.setInt(3, sentence.getYears());
        stmt.setObject(4, sentence.getStart_date());
        stmt.setObject(5, sentence.getEnd_date());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int sentence_id = rs.getInt(1);
            sentence.setSentence_id(sentence_id);
        }
        else throw new SQLException();
    }

    public static void getSentencesLonger(int years) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM sentence WHERE years > ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, years);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int prison_id = rs.getInt("prison_id");
            int case_id = rs.getInt("case_id");

            String prison_name = PrisonDAO.getPrisonName(prison_id);
            String person_name = CriminalCaseDAO.getCriminal(case_id);

            System.out.println(prison_name + ", " + person_name + ", " + rs.getString("years") + " year(s) sentence, "
            + "release date: " + rs.getString("end_date"));
        }
    }
}
