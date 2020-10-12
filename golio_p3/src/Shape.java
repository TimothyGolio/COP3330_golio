abstract class Shape {
    protected double parameter1;
    protected double parameter2;
    protected double parameter3;
    private int intparam1;
    private int intparam2;
    private int intparam3;

    public Shape(double parameter1){
        this.parameter1 = parameter1;
    }

    public Shape(double parameter1, double parameter2){
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public Shape(double parameter1, double parameter2, double parameter3){
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
    }

    public abstract String getName();
    public abstract double getArea();

}
