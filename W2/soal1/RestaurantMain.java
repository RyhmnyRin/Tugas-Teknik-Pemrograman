public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("--- Menu Awal ---");
        menu.tampilMenuMakanan();

        System.out.println("\n--- Melakukan Pemesanan ---");
        menu.pesanMenu(0, 5); // Pesen Pizza 5, harusnya berhasil soalnya stock masih 20
        menu.pesanMenu(1, 25); // Pesen spagetti 25, harusnya error soalnya stock cuman 20

        System.out.println("\n--- Menu Setelah Pemesanan ---");
        menu.tampilMenuMakanan();
    }
}