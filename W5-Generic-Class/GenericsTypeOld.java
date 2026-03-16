public class GenericsTypeOld {
    // 'Object' merupakan cara lama untuk menginisialisi suatu variabel 't' menjadi type data apapun
    private Object t;
    // Method getter bertipe data Object sehingga return nya harus Object juga
    public Object get() {
        return t;
    }
    // Method setter bisa menerima argumen dari type data apapun karena parameternya Object
    public void set(Object t) {
        this.t = t;
    }

    public static void main(String args[]) {
        // Membuat instance dari class
        GenericsTypeOld type = new GenericsTypeOld();
        // Set tipe data String ("Java") ke dalam penampung object
        type.set("Java");
        // type.get() nilainya Object, sehingga perlu memaksa (casting) berubah menjadi String
        // dengan cara menambahkan (String) didepannya
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        // tambahan buat output 
        System.out.println("Nilai: " + str);
    }
}
