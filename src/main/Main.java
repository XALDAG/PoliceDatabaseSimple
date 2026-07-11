import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main() throws Exception {

//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Welcome to the Police Data Base");
//            System.out.println("1. Officer");
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    for (int i = 0; i < 50; i++) {
//                        System.out.println();
//                    }
//                    System.out.println("1. Add officer");
//                    System.out.println("2. Delete officer");
//                    int choice2 = scanner.nextInt();
//            }
//        }


        AddressDAO addressDAO = new AddressDAO();
        Address address = new Address("Street of Spear 67", null, "Miami",
                "Florida", "1922", "USA", 30.9, 23.9,
                LocalDateTime.now(), LocalDateTime.now());
        addressDAO.addAddress(address);

        Officer debra = new Officer("Debra", "Morgan", "Captain", 32, Gender.FEMALE,address.getAddressId());
        OfficerDAO officerDAO = new OfficerDAO();
        officerDAO.addOfficer(debra);

        officerDAO.updateRank(debra.getBadge_number(), "Lieutenant");

        CaseOfficer caseOfficer = new CaseOfficer(8, debra.getBadge_number());
        CaseOfficerDAO caseOfficerDAO = new CaseOfficerDAO();

        caseOfficerDAO.addCaseOfficer(caseOfficer);

        CaseOfficer caseOfficer1 = new CaseOfficer(13, debra.getBadge_number());
        caseOfficerDAO.addCaseOfficer(caseOfficer1);

    }
}
