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
            String input;
            System.out.println("Greetings! Do you have any values you would like to input? (N for no, Y for yes)");
            input = scan.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        }
    }

    public static double getUserHeight(){
        boolean validInput = true;
        Scanner scan = new Scanner(System.in);
        while(validInput){
            System.out.println("Please input a height in inches:");
            double height = Double.parseDouble(scan.nextLine());

            if(height > 0){
                return height;
            }
            else{
                System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        }
    }

    public static double getUserWeight(){
        boolean validInput = true;
        Scanner scan = new Scanner(System.in);
        while(validInput){
            System.out.println("Please input a weight in pounds:");
            double weight = Double.parseDouble(scan.nextLine());

            if(weight > 0){
                return weight;
            }
            else{
                System.out.println("Sorry, that was not a valid input. Please try again.");
            }
        }
    }

    public static void displayBmiInfo(BodyMassIndex BMI){
        double bmiValue = BMI.getBodyMassIndex();
        String bmiCategory = BMI.getBodyMassCategory();

        System.out.println("Your body mass index is: " + bmiValue);
        System.out.println("Your body mass index's category is : " + bmiCategory);
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> values){
        double average = getListAverage(values);
        System.out.println("The average of the inputted BMIs is : " + average);
    }

    public static double getListAverage(ArrayList<BodyMassIndex> values){
        int i, size = values.size();
        double sum = 0;

        for(i = 0; i < size; i++){
            BodyMassIndex curBMI = values.get(i);
            sum = sum + curBMI.getBodyMassIndex()
        }

        return sum / size;
    }
}
