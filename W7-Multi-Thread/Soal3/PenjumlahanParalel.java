package Soal3;
import java.util.Scanner;

public class PenjumlahanParalel {

    // AtomicLong digunakan untuk menyimpan total hasil akhir secara thread-safe
    // bisa juga pakai variabel biasa + synchronized saat update
    static long totalAkhir = 0;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int jumlahThread = sc.nextInt(); // Jumlah thread yang akan digunakan

        System.out.print("Masukkan Angka Akhir: ");
        long angkaAkhir = sc.nextLong(); // Batas atas penjumlahan (1 s.d. angkaAkhir)

        sc.close();

        // Hitung ukuran bagian (chunk) yang dikerjakan setiap thread
        // Contoh: angkaAkhir=1000, jumlahThread=4 → setiap thread kerjakan 250 angka
        long chunkSize = angkaAkhir / jumlahThread;

        // Array untuk menyimpan semua thread yang dibuat
        Thread[] threads = new Thread[jumlahThread];

        // Array untuk menyimpan hasil parsial masing-masing thread
        // Indeks ke-i menyimpan hasil penjumlahan dari thread ke-i
        long[] hasilParsial = new long[jumlahThread];

        System.out.println("\n=== PROSES PENJUMLAHAN PARALEL ===");

        // Buat dan jalankan setiap thread
        for (int i = 0; i < jumlahThread; i++) {

            final int threadIndex = i; // Harus final agar bisa dipakai di lambda

            // Tentukan rentang angka yang dikerjakan thread ini
            final long start = (i * chunkSize) + 1;           // Awal rentang thread ini
            final long end = (i == jumlahThread - 1)           // Akhir rentang thread ini
                    ? angkaAkhir                               // Thread terakhir ambil sisa
                    : (i + 1) * chunkSize;                     // Thread lain sesuai chunk

            threads[i] = new Thread(() -> {

                System.out.println("Thread-" + (threadIndex + 1)
                        + " mengerjakan: " + start + " - " + end);

                // Lakukan penjumlahan untuk rentang yang ditugaskan
                long subtotal = 0;
                for (long j = start; j <= end; j++) {
                    subtotal += j;
                }

                // Simpan hasil parsial di array — aman karena setiap thread
                // hanya menulis ke indeks miliknya sendiri (tidak ada konflik)
                hasilParsial[threadIndex] = subtotal;

                System.out.println("Thread-" + (threadIndex + 1)
                        + " selesai. Hasil parsial: " + subtotal);
            });

            threads[i].start(); // Jalankan thread
        }

        // Tunggu semua thread selesai sebelum menjumlahkan hasil parsial
        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        // Jumlahkan semua hasil parsial menjadi total akhir
        // Ini dilakukan setelah semua thread selesai (setelah join),
        // sehingga tidak perlu synchronized — tidak ada race condition di sini
        for (int i = 0; i < jumlahThread; i++) {
            totalAkhir += hasilParsial[i];
        }

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.println("Total penjumlahan 1 s.d. " + angkaAkhir
                + " menggunakan " + jumlahThread + " thread: " + totalAkhir);

        // Verifikasi dengan rumus matematika: n*(n+1)/2
        long verifikasi = angkaAkhir * (angkaAkhir + 1) / 2;
        System.out.println("Verifikasi (rumus n*(n+1)/2): " + verifikasi);
        System.out.println("Hasil " + (totalAkhir == verifikasi ? "BENAR ✓" : "SALAH ✗"));
    }
}