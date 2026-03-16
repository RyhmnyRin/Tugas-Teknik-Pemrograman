public class GenericsMethods {

    // Java Generic Method
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
        // .equals buat ngebandingin nliai
        return g1.get().equals(g2.get());
    }

    public static void main(String args[]) {
        //membuat 2 object GenericsType yang masing-masing bertipe String
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Java");

        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Java");

        //Cara panggil pertama, agak panjang.
        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);
        // above statement can be written simply as 
        isEqual = GenericsMethods.isEqual(g1, g2);
        System.out.println("Apakah g1 dan g2 sama? " + isEqual); // tes
        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */
        
        // Compiler will infer the type that is needed
    }
}
