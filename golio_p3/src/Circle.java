public class Circle extends Shape2D{

    public Circle(double param){
        super(param);
    }

    @Override
    public String getName(){
        return "circle";
    }

    @Override
    public double getArea(){
        return Math.PI * parameter1 * parameter1;
    }
}
