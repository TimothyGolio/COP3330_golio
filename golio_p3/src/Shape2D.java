abstract class Shape2D extends Shape {

    public Shape2D(double parameter) {
        super(parameter);
    }

    public Shape2D(double parameter, double parameter2) {
        super(parameter, parameter2);
    }

    public abstract double getArea();

}
