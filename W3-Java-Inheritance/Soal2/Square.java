package Soal2;

public class Square extends Rectangle {

    // no arg constructor, default side is 1.0
    public Square() {
        super(1.0, 1.0); // call the constructor of Rectangle with width and length as 1.0
    }

    // constructor with custom side, default color and filled value
    public Square(double side) {
        super(side, side); // call the constructor of Rectangle with width and length as side
    }

    // constructor with custom side, color, and filled value
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled); // call the constructor of Rectangle with width and length as side, custom color and filled value
    }

    public double getSide() {
        return getWidth(); // since width and length are the same for a square, we can return either one
    }

    public void setSide(double side) {
        super.setWidth(side); // set both width and length to the same value for a square
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        setSide(side);// set both width and length to the same value for a square
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
    
    
}
