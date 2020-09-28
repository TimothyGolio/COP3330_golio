public class BodyMassIndex {
    private double height;
    private double weight;

    // BMI constructor
    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    // Returns BMI value as a double
    public double getBodyMassIndex(){

        double result = (703.0 * weight) / (height * height);

        return result;
    }

    // Returns string containing the BMI category
    public String getBodyMassCategory(){
        double BMI = getBodyMassIndex();

        if(BMI >= 30){
            return "Obesity";
        } else if (BMI < 30 && BMI >= 25){
            return "Overweight";
        } else if (BMI < 25 && BMI >= 18.5){
            return "Normal weight";
        } else {
            return "Underweight";
        }
    }
}
