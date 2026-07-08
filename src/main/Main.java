import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {

    public static void main() throws SQLException {
        Address address = new Address("Rue de Dison", "", "Verviers",
                "Liege", "4800", "Belgique", 18.99, 33.22,
                LocalDateTime.now(), LocalDateTime.now());

        AddressDAO addressDAO = new AddressDAO();
        addressDAO.addAddress(address);
        addressDAO.changeAddr1(address.getAddressId(), "Rue de la Concorde");

        Officer officer = new Officer("Debra", "Morgan", "Detective",
                32, address.getAddressId());

        OfficerDAO officerDAO = new OfficerDAO();
        officerDAO.add_officer(officer);
        officerDAO.changeRank(officer.getBadge_number(), "Captain");

        officerDAO.search_by_last_name("Morgan");
    }
}
