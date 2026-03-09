package Soal2;

public class Circle extends Shape {
    private double radius;

    // no arg constructor, default radius is 1.0
    public Circle() {
        super(); // call the no-arg constructor of Shape
        this.radius = 1.0;
    }

    // constructor with custom radius, default color and filled value
    public Circle(double radius) {
        super(); // call the no-arg constructor of Shape
        this.radius = radius;
    }

    // constructor with custom radius, color, and filled value
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // call the parameterized constructor of Shape
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
    
}
