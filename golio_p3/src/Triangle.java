public class Triangle extends Shape2D{

    public Triangle(double param, double param2) {
        super(param, param2);
    }

    @Override
    public String getName(){
        return "triangle";
    }

    @Override
    public double getArea(){
        return (parameter1 * parameter2)/2.0;
    }
}
