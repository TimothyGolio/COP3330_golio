public class Sphere extends Shape3D {

    public Sphere(double param) {
        super(param);
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4.0 * Math.PI * parameter1 * parameter1;
    }

    @Override
    public double getVolume() {
        return (4.0/3.0) * Math.PI * parameter1 * parameter1 * parameter1;
    }
}
