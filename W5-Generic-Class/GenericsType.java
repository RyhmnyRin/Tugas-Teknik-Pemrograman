// '<T>' sebagai Type Parameter, fungsinya agar bisa diisi dengan tipe data asli (dinamis)
public class GenericsType<T> {
    // t bertipe data T
    private T t;
    // return otomatis mengembalikan type data yang sesuai tanpa perlu casting dan nebak-nebak
    public T get() {
        return this.t;
    }
    // Return type nya T, kalo nanti T diset seabgai String, otomatis return nya String
    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        // disini T sudah diganti dengan String, dan terkunci
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // valid, karena Java adalah String
        System.out.println("Nilai Generic Type: " + type.get()); // Cek

        // Raw type tanpa tanda (<>)
        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Java"); // valid, karena java nganggap ini Object
        // Contoh autoboxingf pada raw type, otomatis nge wrap jadi Integer
        type1.set(10); // valid and autoboxing support
        System.out.println("Nilai Raw Type: " + type1.get()); // Cek
    }
}
