import java.util.Scanner;

public class SimpleBot {
    static private final String NAME = "Jake";
    static private final String DATE_OF_BIRTH = "August 5, 2021";

    public static class SimpleBotAcquaintance {
        public static void sayHello () {
            System.out.printf("Hello! My name is %s.\n", NAME);
        }
        public static void sayDateOfBirthday () {
            System.out.printf("I was created in %s.\n", DATE_OF_BIRTH);
        }
    }

        public User registerUser() {
            return new User(askingUserName());
        }
        public String askingUserName() {
            System.out.println("Please, remind me your name.");

            Scanner inputFromConsole = new Scanner(System.in);

            return inputFromConsole.nextLine();
        }
        public void greetingUser(User user) {
            System.out.println("What a great name you have, " + user.getUserName() + "!");
        }
}
