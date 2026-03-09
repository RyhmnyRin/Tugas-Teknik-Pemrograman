package Soal2;

// Ingat: Kalau Shape.java lo pakai 'package Soal2;', 
// file ini juga harus pakai 'package Soal2;' di baris paling atas ya!

public class TestShape {
    public static void main(String[] args) {
        System.out.println("--- PENGUJIAN CLASS SHAPE ---");

        // 1. Menguji No-Arg Constructor (Harusnya green dan filled)
        Shape s1 = new Shape();
        System.out.println("Bentuk 1 (Default):");
        System.out.println(s1.toString());

        // 2. Menguji Parameterized Constructor (buat jadi merah dan tidak terisi)
        Shape s2 = new Shape("red", false);
        System.out.println("\nBentuk 2 (Custom):");
        System.out.println(s2.toString());

        // 3. Menguji Getter dan Setter pada objek s1
        System.out.println("\n--- Mengubah Bentuk 1 pakai Setter ---");
        s1.setColor("blue");
        s1.setFilled(false);

        // Menguji Getter
        System.out.println("Warna Bentuk 1 sekarang: " + s1.getColor());
        System.out.println("Apakah Bentuk 1 terisi? : " + s1.isFilled());

        // Membuktikan perubahan dengan toString()
        System.out.println("Bentuk 1 (Setelah diubah):");
        System.out.println(s1.toString());
    }
}