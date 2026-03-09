package Soal1;
//Hungan Cylinder dengan circle adalah: Cylinder merupakan subclas dari Circle (is-A relationship).
// Cylinder mewarisi semua sifat dari Circle, termasuk radius dan color.
// Cylinder juga memiliki sifat tambahan yaitu height, yang tidak dimiliki oleh Circle. 
// Cylinder dapat dianggap sebagai Circle yang memiliki tinggi, sehingga dapat digunakan untuk menghitung volume berdasarkan luas alas (area) yang diwarisi dari Circle.

public class Cylinder extends Circle { // Save as "Cylinder.java"
    private double height; // private variable

    // Constructor with default color, radius and height
    public Cylinder() {
        super(); // call superclass no-arg constructor Circle()
        this.height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass constructor Circle(radius, color)
        this.height = height;
    }

    // Constructor with default costumized color
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // call superclass constructor Circle(radius, color)
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    // Override the getArea() method, karena luas permukaan tabung berbeda dengan
    // luas lingkaran
    @Override
    public double getArea() {
        return (2 * Math.PI * getRadius() * getHeight()) + (2 * super.getArea()); // call superclass method getArea()
    }

    // A public method for computing the volume of cylinder
    // use superclass method getArea() to get the base area
    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() { // di dalam kelas Cylinder
        return "Cylinder: subclass of " + super.toString() // menggunakan toString() milik Circle
                + " height=" + height;
    }

}
