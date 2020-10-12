abstract class Shape3D extends Shape{

    public Shape3D(double parameter) {
        super(parameter);
    }

    public Shape3D(double parameter, double parameter2) {
        super(parameter, parameter2);
    }

    public Shape3D(double parameter, double parameter2, double parameter3) {
        super(parameter, parameter2, parameter3);
    }

    public abstract double getVolume();
    public abstract double getArea();
}
