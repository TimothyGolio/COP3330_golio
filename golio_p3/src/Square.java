public class Square extends Shape2D {

    public Square(double param) {
        super(param);
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return parameter1 * parameter1;
    }
}
