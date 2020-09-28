import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    public static boolean moreInput(){
        boolean answerExists = true;
        Scanner scan = new Scanner(System.in);

        while(answerExists) {
            System.out.println("Greetings! Do you have any values you would like to input? (0 for no, 1 for yes)");
            int input = Integer.parseInt(scan.nextLine());
            if (input == 1) {
                return true;
            } else if (input == 0) {
                return false;
            } else {
                System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        }
    }

    public static double getUserHeight(){
        Scanner scan
    }
}
