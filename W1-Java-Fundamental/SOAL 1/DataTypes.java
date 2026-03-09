import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner cek = new Scanner(System.in);
        System.out.println("Masukan Banyak Angka: ");
        int banyakData = cek.nextInt();
        
        for (int i=1; i<=banyakData; i++) {

            System.out.println("masukan angka ke-" + i);
            try{
                long n = cek.nextLong();
                System.out.println(n + " can be fitted in: ");

                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE){
                System.out.println("* byte");
                }  

                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE){
                System.out.println("* short");
                }
                
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE){
                System.out.println("* int");
                }

                if (n >= Long.MIN_VALUE && n <= Long.MAX_VALUE){
                System.out.println("* long");
                }
                      
            } catch (Exception e) {
                System.out.println(cek.next() + " can't be fitted anywhere");
            }
        }
        cek.close();
    }
}
 