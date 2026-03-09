public class Restaurant {
    // 1. ATRIBUT
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    // 2. CONSTRUCTOR
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // 3. GETTER & SETTER PUBLIC
    public String getNamaMakanan(int idMenu) {
        return nama_makanan[idMenu];
    }
    public void setNamaMakanan(int idMenu, String nama) {
        nama_makanan[idMenu] = nama;
    }

    public double getHargaMakanan(int idMenu) {
        return harga_makanan[idMenu];
    }
    public void setHargaMakanan(int idMenu, double harga) {
        harga_makanan[idMenu] = harga;
    }

    public int getStok(int idMenu) {
        return stok[idMenu];
    }
    public void setStok(int idMenu, int stokBaru) {
        if (stokBaru < 0) {
            System.out.println("Error: Stok tidak boleh negatif!");
        } else {
            stok[idMenu] = stokBaru;
        }
    }

    // 4. METHOD TAMBAH MENU
    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stokAwal);
    }

    // 5. METHOD TAMPIL MENU
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(getNamaMakanan(i) + "[" + getStok(i) + "]\tRp. " + getHargaMakanan(i));
            }
        }
    }

    // 6. METHOD PESAN MENU (Mini Case)
    public void pesanMenu(int idMenu, int jumlahPesanan) {
        if (jumlahPesanan < 0) {
            System.out.println("Jumlah pesanan tidak valid!");
        } else if (getStok(idMenu) >= jumlahPesanan) {
            setStok(idMenu, getStok(idMenu) - jumlahPesanan);
            System.out.println("Berhasil pesan " + getNamaMakanan(idMenu) + " sebanyak " + jumlahPesanan);
        } else {
            System.out.println("Maaf, stok " + getNamaMakanan(idMenu) + " tidak mencukupi.");
        }
    }

    public boolean isOutOfStock(int idMenu) {
        return getStok(idMenu) == 0;
    }

    public static void nextId() {
        id++;
    }
}