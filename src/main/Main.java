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



        SentenceDAO.getSentencesLonger(1);
    }
}
