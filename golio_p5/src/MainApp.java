import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        int appMenuResponse = 0;
        while(appMenuResponse != 3) {
            appMenuResponse = manageAppMenu();

            if(appMenuResponse == 1) {
                TaskApp.mainTaskAppMenu();
            } else if (appMenuResponse == 2) {
                ContactApp.mainContactAppMenu();
            } else {
            }
        }
    }

    private static int manageAppMenu() {
        printAppMenu();
        Scanner scan = new Scanner(System.in);

        try {
            int appMenuResponse = scan.nextInt();

            if(appMenuResponse > 0 && appMenuResponse <= 3) {
                return appMenuResponse;
            } else {
                System.out.println("Your input was invalid, must be from 1-3. Please try again.");
                return -1;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Your input was invalid, must be an integer from 1-3. Please try again.");
            return -1;
        } catch (InputMismatchException e2) {
            System.out.println("Your input was invalid, must be an integer. Please try again.");
            return -1;
        }
    }

    // Prints the app menu.
    private static void printAppMenu() {
        System.out.println("Select Your Application");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println("");
    }
}
