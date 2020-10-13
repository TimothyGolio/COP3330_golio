public class Cube extends Shape3D{

    public Cube(double param) {
        super(param);
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * parameter1 * parameter1;
    }

    @Override
    public double getVolume() {
        return parameter1 * parameter1 * parameter1;
    }
}
