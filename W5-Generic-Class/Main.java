// T type datanya bebas asalkan mengimplement interface Comparable
// Interface Comparable bawan java
interface MinMax<T extends Comparable<T>> {
    T max();
}

// class MyClass juga harus declare batasan yang sama
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }
    // Cari nilai max
    public T max() {
        T v = vals[0];
        
        for (int i = 1; i < vals.length; i++) {
            // Menggunakan method compareTo dari interface Comparable
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        // Class Integer dan Character bawaan java udh otomatis mengimplement Comparable
        Integer[] inums = {3, 6, 2, 8, 6};
        Character[] chs = {'b', 'r', 'p', 'w'};
        // valid, karena Integer dan Characte turunan dari Comparable
        MyClass<Integer> a = new MyClass<>(inums);
        MyClass<Character> b = new MyClass<>(chs);

        System.out.println("Nilai Integer Terbesar: " + a.max()); // cek
        System.out.println("Karakter Terbesar: " + b.max()); // cek
    }
}
