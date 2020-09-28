public class BodyMassIndex {
    private double height;
    private double weight;

    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    public double getBodyMassIndex(){
        double result = (703 * weight) / (height * height);
        return result;
    }

    public String getBodyMassCategory(){
        double BMI = getBodyMassIndex();

        if(BMI >= 30){
            return "Obesity";
        } else if (BMI < 30 && BMI >= 25){
            return "Overweight";
        } else if (BMI < 25 && BMI >= 18.5){
            return "Normal weight";
        } else if (BMI < 18.5 && BMI > 0){
            return "Underweight";
        } else {
            return "Error";
        }
    }
}
