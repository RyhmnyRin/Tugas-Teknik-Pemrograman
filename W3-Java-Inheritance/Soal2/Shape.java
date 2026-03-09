package Soal2;

public class Shape {
    private String color;
    private boolean filled;

    // no arg constructor, default color is green and filled is true
    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    // constructor with custom color and filled value
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // getter and setter for color and filled
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String status;

        if (filled == true) {
            status = "filled";
        } else {
            status = "Not filled";
        }

        return "A Shape with color of " + color + " and " + status;
    }
}
