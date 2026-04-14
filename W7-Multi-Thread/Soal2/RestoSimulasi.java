public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto(); // Satu objek resto, dipakai bersama

        // Runnable berisi tugas yang akan dijalankan oleh setiap kasir (thread)
        // Masing-masing kasir melayani 40 pelanggan
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        // buat 3 thread buat tugas yang sama
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        // tunggu semua kash selesai 
        kasir1.join();
        kasir2.join();
        kasir3.join();

        // total yang dilayani = 3 kasir x 40 = 120, sementara stock ada 100
        // karena pake synchronized, yang terjual pas 100, sementara 20 sisanya gagal. sisa 0
        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
