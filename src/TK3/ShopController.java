package TK3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopController extends Item {
    private List<Item> cart = new ArrayList<>();

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean counter = true;
        while (counter) {
            int menu;
            System.out.println(" ");
            System.out.println("=====================================");
            System.out.println("********** SELAMAT DATANG ***********");
            System.out.println("             MENU UTAMA              ");
            System.out.println(" ");
            System.out.println("1. Tambah Produk");
            System.out.println(" ");
            System.out.println("2. Hapus Produk");
            System.out.println(" ");
            System.out.println("3. Update Produk");
            System.out.println(" ");
            System.out.println("4. Lihat Produk");
            System.out.println(" ");
            System.out.println("5. Keluar");
            System.out.println(" ");
            System.out.println("=====================================");
            try {
                System.out.println("Silahkan memilih menu.");
                System.out.print("Pilih: ");
                menu = input.nextInt();
                switch(menu){
                    case 1:
                        tambahProduk();
                        break;
                    case 2:
                        hapusProduk();
                        break;
                    case 3:
                        updateProduk();
                        break;
                    case 4:
                        lihatProduk();
                        break;
                    case 5:
                        System.out.println("Terima kasih sudah berkunjung");
                        System.exit(5);
                        break;
                    default :
                        System.out.println("Menu tidak tersedia, silahkan input ulang");
                        boolean repeat = true;

                        while (repeat)
                        {
                            System.out.print("Pilih: ");
                            menu = input.nextInt();
                            switch (menu)
                            {
                                case 1:
                                    tambahProduk();
                                    repeat = false;
                                    break;

                                case 2:
                                    hapusProduk();
                                    repeat = false;
                                    break;
                                case 3:
                                    updateProduk();
                                    repeat = false;
                                    break;
                                case 4:
                                    lihatProduk();
                                    repeat = false;
                                    break;
                                case 5:
                                    System.out.println("Terima kasih sudah berkunjung");
                                    System.exit(5);
                                    break;
                                default:
                                    repeat = true;
                                    System.out.println("Menu tidak tersedia, silahkan input ulang");
                            }
                        }
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println(n);
            }
        }
    }

    private void tambahProduk() {
        Scanner input = new Scanner(System.in);
        Item item = new Item();
        System.out.println("                Tambah Data                 ");
        System.out.println("Silahkan input produk yang ingin ditambahkan");
        System.out.println(" ");
        try {
            System.out.print("Nama: ");
            item.nama = input.nextLine();
            System.out.print("Jumlah: ");
            item.qty = input.nextInt();
            cart.add(item);
            System.out.println("Data Berhasil Ditambahkan");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void hapusProduk() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("                     Hapus Produk                      ");
        System.out.print("Silahkan input nama produk yang akan dihapus :");
        String search = input.nextLine();
        while (repeat) {
            boolean isExist = false;
            for (Item i : cart) {
                boolean exist = i.nama.equals(search);
                if (exist) {
                    isExist = exist;
                    break;
                }
            }
            if (isExist) {
                System.out.println("Apakah Anda yakin mau menghapus produk ini dari keranjang Anda? [Ya | Tidak]");
                System.out.print("Pilih: ");
                String decision = input.nextLine();
                switch(decision){
                    case "Ya":
                    case "ya":
                        cart.removeIf(it -> it.nama.equals(search));
                        System.out.println("Produk berhasil dihapus");
                        repeat = false;
                        break;
                    case "Tidak":
                    case "tidak":
                        repeat = false;
                        break;
                    default :
                        System.out.println("Silahkan ikuti default value [Ya | Tidak] ketika input.");
                        System.out.println(" ");
                        System.out.println("Apakah Anda yakin mau menghapus produk ini dari keranjang Anda? [Ya | Tidak]");
                        System.out.print("Pilih: ");
                        boolean repeat2 = true;

                        while (repeat2)
                        {
                            decision = input.nextLine();
                            switch (decision)
                            {
                                case "Ya":
                                case "ya":
                                    cart.removeIf(it -> it.nama.equals(search));
                                    System.out.println("Produk berhasil dihapus");
                                    repeat2 = false;
                                    repeat = false;
                                    break;
                                case "Tidak":
                                case "tidak":
                                    repeat2 = false;
                                    repeat = false;
                                    break;
                                default:
                                    System.out.println("Silahkan ikuti default value [Ya | Tidak] ketika input.");
                                    System.out.println(" ");
                                    System.out.println("Apakah Anda yakin mau menghapus produk ini dari keranjang Anda? [Ya | Tidak]");
                                    System.out.print("Pilih: ");
                                    repeat = true;
                            }
                        }
                        break;
                }
            } else {
                System.out.println("Produk yang dicari tidak ada");
                repeat = false;
                break;
            }
        }
    }

    private void updateProduk() {

    }

    private void lihatProduk() {
        System.out.println("                     Lihat Produk                      ");
        System.out.println("Berikut merupakan list keranjang yang telah ditambahkan");
        System.out.println(" ");
        if (cart.size() > 0) {
            for (int i=0; i < cart.size(); i++) {
                Item item = cart.get(i);
                int counter = i + 1;
                System.out.println(counter +". Nama Produk: " + item.nama);
                System.out.println("   Jumlah Produk: " + item.qty);
                System.out.println(" ");
            }
        } else {
            System.out.println("Keranjang kosong, silahkan tambahkan produk terlebih dahulu");
        }
    }
}
