package Soal2;

public class Rectangle extends Shape {
    private double width;
    private double length;

    // no arg constructor, default width and length is 1.0
    public Rectangle() {
        super(); // call the no-arg constructor of Shape, memanggil green dan true dari shape
        this.width = 1.0;
        this.length = 1.0;
    }

    // constructor with custom width and length, default color and filled value
    public Rectangle(double width, double length) {
        super(); // call the no-arg constructor of Shape, memanggil green dan true dari shape
        this.width = width;
        this.length = length;
    }

    // constructor with custom width, length, color, and filled value
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled); // call the parameterized constructor of Shape, custom color dan filled value
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of " + super.toString();
    }

}
