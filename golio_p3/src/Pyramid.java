public class Pyramid extends Shape3D{

    public Pyramid(double param1, double param2, double param3){
        super(param1, param2, param3);
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return (parameter1 * parameter2) + (parameter1 * Math.sqrt(Math.pow((parameter2/2.0), 2) + Math.pow(parameter3, 2))) + (parameter2 * Math.sqrt(Math.pow((parameter1/2.0), 2) + Math.pow(parameter3, 2)));
    }

    @Override
    public double getVolume(){
        return (parameter1 * parameter2 * parameter3)/3.0;
    }
}
