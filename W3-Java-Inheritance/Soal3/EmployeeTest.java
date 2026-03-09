package Soal3;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        System.out.println("--- Data Sebelum Diurutkan ---");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Memanggil metode compare di dalam kelas EmployeeTest
        System.out.println("\n--- Menguji Metode Compare ---");
        System.out.println("Bandingkan gaji Antonio (2jt) dengan Maria (2.5jt): " + staff[0].compare(staff[1])); // Hasil harus -1 (lebih kecil)
        System.out.println("Bandingkan gaji Isabel (3jt) dengan Maria (2.5jt): " + staff[2].compare(staff[1])); // Hasil harus 1 (lebih besar)

        // Pembuktikan shell_sort berfungsi
        System.out.println("\n--- Data Setelah Diurutkan Berdasarkan Gaji (Shell Sort) ---");
        Sortable.shell_sort(staff);
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
    }
}