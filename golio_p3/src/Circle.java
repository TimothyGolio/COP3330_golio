public class Circle extends Shape2D{
    private int radius;

    public Circle(double radius){
        super(radius);
    }

    @Override
    public String getName(){
        return "circle";
    }

    @Override
    public double getArea(){
        return 2.0 * Math.PI * radius;
    }
}
