package TK3;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class main {
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
    ArrayList<ArrayList<String>> MenuList = new ArrayList();

    int menu = 0;
    while(menu != 5){
        ArrayList<String> AddMenu = new ArrayList();
        ArrayList<String> SearchList = new ArrayList();
        String nama;
        String qty;

        // menu 1
        try{
            System.out.println("----------------------------------------------");
            System.out.println("1. Tambah Produk\n2. Hapus Produk\n3. Ubah Produk\n4. Lihat Produk\n5 Keluar");
            System.out.println("Masukkan Pilihan Menu: ");
            menu = input.nextInt();
            input.nextLine();
            switch(menu){
                // case 1
                case 1:
                    System.out.print("Nama Menu: ");
                    nama = input.nextLine();
                    AddMenu.add(nama);
                    //membuat berapa jumlah produk yang tersedia
                    System.out.println("QTY: ");
                    qty = input.nextLine();
                    AddMenu.add(qty);
                    MenuList.add(AddMenu);
                    break;
                 // case 2
                case 2:
                    int position = -1;
                    for(int i=0; i<MenuList.size(); i++){
                        SearchList.add(MenuList.get(i).get(0));
                    }
                    System.out.println(("----------------------------------------------"));
                    System.out.print("Masukkan Nama Produk: ");
                    String g = input.nextLine();
                    if(SearchList.contains(g)){
                        position = SearchList.indexOf(g);
                        System.out.println("Produk" +g+ "tersedia");
                        System.out.print("Apakah anda yakin mau menghapus nama produk tersebut dari list keranjang? [Ya | Tidak]: ");
                        String confirm = input.nextLine();
                        if(confirm.equals("Ya") || confirm.equals("ya")){
                            MenuList.remove(position);
                            System.out.println(" Produk Berhasil Dihapus");
                            break;
                        } else if (confirm.equals("Tidak") || confirm.equals("tidak")){
                            System.out.println("Data Tidak Jadi Dihapus");
                            break;
                        } else {
                            System.out.println("Masukkan Ya / Tidak");
                            break;
                        }
                        }else {
                            System.out.println("Produk yang dicari tidak ada");
                            break;
                        }
                     //Case 3
                        case 3:
                            int posisi= -1;
                            for(int i=0; i<MenuList.size(); i++){
                                SearchList.add(MenuList.get(i).get(0));
                            }
                         System.out.println("----------------------------------------------");
                         System.out.print("Masukkan Nama Produk: ");
                         String s=input.nextLine();
                         //agar produk bisa diubah
                         if (SearchList.contains(s)){
                             posisi = SearchList.indexOf(s);
                             System.out.println("Produk" +s+ "ditemukan, masukkan data baru");
                             System.out.print("Nama: ");

                             nama = input.nextLine();
                             AddMenu.add(nama);
                             System.out.print("QTY: ");
                             qty = input.nextLine();
                             AddMenu.add(qty);

                             System.out.print("Apakah anda yakin mau mengubah produk ini? [Ya | Tidak]: ");
                             String confirm = input.nextLine();
                             if(confirm.equals("Ya") || confirm.equals("ya")){
                                 MenuList.set(posisi,AddMenu);
                                 System.out.println("Data Produk Berhasil Diubah");
                                 break;
                             }else{
                                 System.out.println("Masukkan Ya / Tidak");
                                 break;
                             }
                        }else {
                             System.out.println("Produk yang dicari tidak ada");
                             break;
                    }
                    //Case 4
                        case 4:
                            int index3 = 0;
                            System.out.println("----------------------------------------------");
                            System.out.println("Nama Menu"+"\t"+"QTY");
                            for (int i = 0; i<MenuList.size(); i++){
                                index3++;
                                System.out.println(index3+" "+ MenuList.get(i).get(0)+"\t\t"+ MenuList.get(i).get(1));
                            }
                            System.out.println("----------------------------------------------");
                            break;
                     //Case 5
                        case 5:
                            System.out.println("----------------------------------------------");
                            System.out.println("Thank you");
                            System.out.println("----------------------------------------------");
                            return;
            }
                }catch(InputMismatchException e ){
                    System.out.println("----------------------------------------------");
            System.out.println("Pilih Menu Menggunakan Angka");
            return;
        }
    }
    }
}