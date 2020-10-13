import java.lang.reflect.Array;

public class Main {
    public static void main(String args[]) {

        Shape square1 = new Square(13);
        Shape triangle1 = new Triangle(12, 13);
        Shape circle1 = new Circle(13);
        Shape cube1 = new Cube(13);
        Shape pyramid1 = new Pyramid(13, 12, 20);
        Shape sphere1 = new Sphere(13);

        double printy;
        String name;

        name = square1.getName();
        System.out.println("Square one name: " + name);
        name = triangle1.getName();
        System.out.println("Triangle one name: " + name);
        name = circle1.getName();
        System.out.println("Circle one name: " + name);
        name = cube1.getName();
        System.out.println("Cube one name: " + name);
        name = pyramid1.getName();
        System.out.println("Pyramid one name: " + name);
        name = sphere1.getName();
        System.out.println("Sphere one name: " + name);

        System.out.println();

        printy = square1.getArea();
        System.out.println("Square one area: " + printy);
        printy = triangle1.getArea();
        System.out.println("Triangle one area: " + printy);
        printy = circle1.getArea();
        System.out.println("Circle one area: " + printy);
        printy = cube1.getArea();
        System.out.println("Cube one area: " + printy);
        printy = pyramid1.getArea();
        System.out.println("Pyramid one area: " + printy);
        printy = sphere1.getArea();
        System.out.println("Sphere one area: " + printy);

        System.out.println();

        Shape2D square2 = new Square(13);
        Shape2D triangle2 = new Triangle(12, 13);
        Shape2D circle2 = new Circle(13);

        name = square2.getName();
        System.out.println("Square two name: " + name);
        name = triangle2.getName();
        System.out.println("Triangle two name: " + name);
        name = circle2.getName();
        System.out.println("Circle two name: " + name);

        System.out.println();

        printy = square2.getArea();
        System.out.println("Square two area: " + printy);
        printy = triangle2.getArea();
        System.out.println("Triangle two area: " + printy);
        printy = circle2.getArea();
        System.out.println("Circle two area: " + printy);

        System.out.println();

        Shape3D cube2 = new Cube(12.7);
        Shape3D pyramid2 = new Pyramid(0.1, 100.67, 10.1678);
        Shape3D sphere2 = new Sphere(1.11111);

        System.out.println();

        name = cube2.getName();
        System.out.println("Cube two name: " + name);
        name = pyramid2.getName();
        System.out.println("Pyramid two name: " + name);
        name = sphere2.getName();
        System.out.println("Sphere two name: " + name);

        System.out.println();

        printy = cube2.getArea();
        System.out.println("Cube two area: " + printy);
        printy = pyramid2.getArea();
        System.out.println("Pyramid two area: " + printy);
        printy = sphere2.getArea();
        System.out.println("Sphere two area: " + printy);

        System.out.println();

        printy = cube2.getVolume();
        System.out.println("Cube two volume: " + printy);
        printy = pyramid2.getVolume();
        System.out.println("Pyramid two volume: " + printy);
        printy = sphere2.getVolume();
        System.out.println("Sphere two volume: " + printy);
    }
}
