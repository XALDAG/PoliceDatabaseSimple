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
        Address address = new Address("Street of Big Port 11", null, "Miami",
                "Florida", "1922", "USA", 33.9, 29.9,
                LocalDateTime.now(), LocalDateTime.now());
        Address address2 = new Address("Street LaGuerta 21", null, "Miami",
                "Florida", "1922", "USA", 37.9, 19.9,
                LocalDateTime.now(), LocalDateTime.now());
        Address address3 = new Address("Street of Highhills", null, "Miami",
                "Florida", "1922", "USA", 36.9, 29.9,
                LocalDateTime.now(), LocalDateTime.now());
        addressDAO.addAddress(address);
        addressDAO.addAddress(address2);
        addressDAO.addAddress(address3);

        PersonDAO personDAO = new PersonDAO();
        Person michael = new Person("Michael", "de Santa", 41, Gender.MALE, address.getAddressId());
        personDAO.addPerson(michael);
        Person trevor = new Person("Trevor", "Philips", 47, Gender.MALE, address2.getAddressId());
        personDAO.addPerson(trevor);
        Person frank = new Person("Franklin", "Clinton", 29, Gender.MALE, address3.getAddressId());
        personDAO.addPerson(frank);

        Crime crime = new Crime("Assault on police officer", "Violent");
        Crime crime2 = new Crime("Robbery", "Violent");
        Crime crime3 = new Crime("Racist slurs against sea turtles", "Hate");
        Crime crime4 = new Crime("Possession of Cocaine", "Drugs");
        Crime crime5 = new Crime("Exploitation of Migrants from Saturn", "Human trafficking");
        CrimeDAO crimeDAO = new CrimeDAO();
        crimeDAO.addCrime(crime);
        crimeDAO.addCrime(crime2);
        crimeDAO.addCrime(crime3);
        crimeDAO.addCrime(crime4);
        crimeDAO.addCrime(crime5);

        CriminalCase criminalCase = new CriminalCase(michael.getPerson_id(), crime4.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCase criminalCase2 = new CriminalCase(michael.getPerson_id(), crime2.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCase criminalCase3 = new CriminalCase(trevor.getPerson_id(), crime5.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCase criminalCase4 = new CriminalCase(trevor.getPerson_id(), crime.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCase criminalCase5 = new CriminalCase(trevor.getPerson_id(), crime3.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCase criminalCase6 = new CriminalCase(frank.getPerson_id(), crime2.getCrime_id(), LocalDate.now(), LocalDate.now());
        CriminalCaseDAO criminalCaseDAO = new CriminalCaseDAO();
        criminalCaseDAO.addCriminalCase(criminalCase);
        criminalCaseDAO.addCriminalCase(criminalCase2);
        criminalCaseDAO.addCriminalCase(criminalCase3);
        criminalCaseDAO.addCriminalCase(criminalCase4);
        criminalCaseDAO.addCriminalCase(criminalCase5);
        criminalCaseDAO.addCriminalCase(criminalCase6);


        criminalCaseDAO.crimes_by_id(trevor.getPerson_id());
    }
}
