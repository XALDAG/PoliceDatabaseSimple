import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {

    public static void main() throws SQLException {

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

        Address address = new Address("Street of Big Port", null, "Miami",
                "Florida", "1922", "USA", 33.9, 29.9,
                LocalDateTime.now(), LocalDateTime.now());
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.addAddress(address);

        Person person = new Person("Michael", "de Santa", 41, Gender.MALE, address.getAddressId());
        PersonDAO personDAO = new PersonDAO();
        personDAO.addPerson(person);


    }
}
