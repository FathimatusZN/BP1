/*
Nama  : Fathimatus Z. N.
NPM   : 22082010156
Kelas : Paralel D
Tugas : FINAL PROJECT BP 1 (Th. 2022)
*/

package bp_uas;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UAS_BP_FIX {

   public static Scanner input = new Scanner(System.in);
   public static int[][] barang = new int[100][4];   
   public static String[] barang2 = new String[100];
   public static int[][] hargaa = new int[100][1000];
   public static String[][] transaksi = new String[100][1000];
   public static int jumlah, indeks, baris, kolom, colsort, harga, total, totalsemua, carikode, p;
   public static String cari, time, kasir;
   public static boolean ketemu, match;
   public static LocalDateTime mytime;
   public static DateTimeFormatter mytime2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   
   public static void cetak() {
      sort();
      System.out.println("------------------------- LIST BARANG UPN STORE -------------------------");
      System.out.println("Kode \tNama \t\tHarga \t   Stok \tTerjual");
      for(int i=0; i<=jumlah-1; i++){
         System.out.println(barang[i][0] +"\t"+ barang2[i] +"\t\t"+ barang[i][1] +"\t   "+ barang[i][2] +"\t\t  "+ barang[i][3] );
      }
      System.out.println("-------------------------------------------------------------------------");
   }
   
   public static void searchnama() {
      ketemu = false;
      cari = input.next();
      for(int j=0; j<jumlah; j++){
         if(cari.equalsIgnoreCase(barang2[j])){
            ketemu=true;
            indeks = j;
            break;
         }
      }
   }
   
   public static void searchkode() {
      for(int j=0; j<jumlah; j++){
         if(carikode==barang[j][0]){
             ketemu=true;
             indeks = j;
             break;
         }
      }
   }
   
   public static void sort() {
      int temp1, temp3, temp4, temp5;
      String temp2;
      
      for(int a=0; a<=jumlah-2; a++){
         for(int b=jumlah-1; b>a; b--){
            if(barang[b][colsort] < barang[b-1][colsort]){
               
               //swap kode
               temp1 = barang[b][0];
               barang[b][0] = barang[b-1][0];
               barang[b-1][0] = temp1;
               
               //swap barang
               temp2 = barang2[b];
               barang2[b] = barang2[b-1];
               barang2[b-1] = temp2;
               
               //swap harga
               temp3 = barang[b][1];
               barang[b][1] = barang[b-1][1];
               barang[b-1][1] = temp3;
               
               //swap stok
               temp4 = barang[b][2];
               barang[b][2] = barang[b-1][2];
               barang[b-1][2] = temp4;
               
               //swap terjual
               temp5 = barang[b][3];
               barang[b][3] = barang[b-1][3];
               barang[b-1][3] = temp5;
            }
         }
      }
   }
   
   public static void waktuu() {
      mytime = LocalDateTime.now();
      time = mytime.format(mytime2);
   }
   
   public static void kasirr() {
      p=2;
      System.out.println("\n\n_____________________________________________________");
      System.out.println("-----------------------------------------------------");
      System.out.println("\t\t      UPN STORE");
      System.out.println("\t        JL. RUNGKUT MADYA NO.1 ");
      System.out.println("\t\t      SURABAYA");
      System.out.println("\t\t     0810000011\n");
      System.out.println("-----------------------------------------------------");
      System.out.println("Nama Barang \tQty \tHarga \t\tTotal");
      System.out.println("-----------------------------------------------------");
      for(int i=0; i<hargaa[baris][0]; i++){
         carikode = hargaa[baris][p+(3*i)];
         searchkode();
         System.out.println(barang2[indeks] +"\t\t"+ hargaa[baris][3+(3*i)] +"\t"+ barang[indeks][1] +"\t\t"+ hargaa[baris][4+(3*i)]);
      }
      System.out.println("-----------------------------------------------------");
      System.out.println(hargaa[baris][0]+" item(s) \t\t\t TOTAL \t" + hargaa[baris][1]);
      System.out.println("\n\nTgl / Waktu \t : " + transaksi[baris][0]);
      System.out.println("Kasir \t\t : " + transaksi[baris][1]);
      System.out.println("\n\t~~ Terima kasih telah berbelanja ~~");
      System.out.println(  "\t  ~~~~~ Have a good day :) ~~~~~");
      System.out.println("-----------------------------------------------------");
      System.out.println("_____________________________________________________\n\n");
   }
   
   public static void login() {
      String uname = "admin123";
      String passw = "123456";
      match = false;
      int loop=3;
      
      do{
         System.out.print("Masukkan username : ");
         String username = input.next();
         System.out.print("Masukkan password : ");
         String password = input.next();

         if(username.equals(uname) && password.equals(passw)){
            match = true;
            break;
         }
         else{
            System.out.println("Username atau Password SALAH!");
            System.out.println("Kesempatan login tersisa : " +(loop-1));
         }
         loop--;
      }while(loop>0);
   }
    
   public static void main(String[] args) {
      System.out.println("SISTEM KASIR UPN STORE");
      login();
      System.out.println("");
      
      if(match==true){
         int user;
         barang[0][0]=1001; barang2[0]="Buku"; barang[0][1]=3500; barang[0][2]=150;
         barang[1][0]=1002; barang2[1]="Bolpoin"; barang[1][1]=2000; barang[1][2]=140;
         barang[2][0]=1003; barang2[2]="Binder"; barang[2][1]=9000; barang[2][2]=70;
         barang[3][0]=1004; barang2[3]="Folio"; barang[3][1]=700; barang[3][2]=210;
         barang[4][0]=1005; barang2[4]="HVS"; barang[4][1]=400; barang[4][2]=250;
         jumlah = 5; 
         baris = 0;

         do{
            System.out.println("=============== SELAMAT DATANG DI SISTEM KASIR UPN STORE =================");
            System.out.println("====> 1. Kasir \t    2. Admin \t  3. Owner \t4. Keluar Program  <====");
            System.out.print("==> Pilih nomor jenis user : ");
            user = input.nextInt();
            System.out.println("");

            switch(user){

               //AKUN KASIR
               case 1 -> {
                  int menu;
                  System.out.println("_____________________________KASIR UPN STORE_____________________________");
                  System.out.print("Nama Kasir : ");
                  kasir = input.next();
                  do{
                     System.out.println("1. Cari Barang \t2. Transaksi Pembelian \t3. Keluar Kasir");
                     System.out.print("==> Select : ");
                     menu = input.nextInt();
                     System.out.println("");

                     switch(menu){
                        //CARI BARANG
                        case 1 -> {
                           System.out.println("\t\t\t   ---> Cari Barang <---");
                           System.out.print("==> Masukkan nama barang yang ingin dicari : ");
                           searchnama();
                           System.out.println("Barang yang dicari = " +cari);
                           if(ketemu){
                              System.out.println("Kode : " +barang[indeks][0]+ "\t| Harga : " +barang[indeks][1]+ "\t| Stok : " +barang[indeks][2]+ "\t| Terjual : " +barang[indeks][3]+ "\n");
                           }
                           else{
                              System.out.println("Tidak terdapat dalam data. \n");
                           }
                        }

                        //TRANSAKSI
                        case 2 -> {
                           System.out.println("\t\t\t   ---> Transaksi <---");
                           int tambah, jmlh;
                           kolom=2; total=0; colsort=0;
                           cetak();

                           do{
                              System.out.print("Masukkan barang \t\t: "); searchnama();

                              //Barang ada
                              if (ketemu==true){
                                 System.out.print("Jumlah \t\t\t\t: ");
                                 jmlh = input.nextInt();

                                 if(jmlh<=barang[indeks][2]){
                                    harga = jmlh * barang[indeks][1];
                                    barang[indeks][2] = barang[indeks][2] - jmlh;
                                    barang[indeks][3] = barang[indeks][3] + jmlh;
                                    hargaa[baris][kolom] = barang[indeks][0];
                                    hargaa[baris][kolom+1] = jmlh;
                                    
                                    //array hargaa kolom 0 (jumlah jenis barang)
                                    hargaa[baris][0] = hargaa[baris][0] + 1;

                                    //array harga kolom 5, 8, 11, dst.. (total harga per jenis barang)
                                    hargaa[baris][kolom+2] = harga; 
                                    kolom = kolom + 3;
                                 }

                                 //barang > stok
                                 else if(jmlh>barang[indeks][2] && barang[indeks][2]>0){
                                    System.out.println("!!! Stok kurang, hanya ada " +barang[indeks][2]+", tetap beli sebanyak " +barang[indeks][2]+"?");
                                    System.out.print("1. Ya, 2.Tidak \t\t: ");
                                    int choose = input.nextInt();
                                    if(choose==1){
                                       jmlh=barang[indeks][2];
                                       harga = jmlh * barang[indeks][1];
                                       barang[indeks][2] = barang[indeks][2] - jmlh;
                                       barang[indeks][3] = barang[indeks][3] + jmlh;
                                       hargaa[baris][kolom] = barang[indeks][0];
                                       hargaa[baris][kolom+1] = jmlh;
                                    }
                                    
                                    //array hargaa kolom 0 (jumlah jenis barang)
                                    hargaa[baris][0] = hargaa[baris][0] + 1;

                                    //array harga kolom 5, 8, 11, dst.. (total harga per jenis barang)
                                    hargaa[baris][kolom+2] = harga; 
                                    kolom = kolom + 3;
                                 }
                                 //Barang habis
                                 else{
                                    System.out.println("Stok barang habis.");
                                 }
                              }
                              else{
                                 System.out.println("Barang tidak ada.");
                              }


                              total = total + harga;
                              System.out.print("Tambah barang? (1. Ya; 2. Tidak): ");
                              tambah = input.nextInt();

                           }while(tambah!=2);

                           //array hargaa kolom ke 2 (total harga)
                           hargaa[baris][1] = total;
                           System.out.println("\nJumlah yang dibayar \t\t: Rp. " + hargaa[baris][1]);
                           waktuu(); transaksi[baris][0] = time;
                           System.out.println("Waktu Transaksi \t\t: " +transaksi[baris][0]);
                           transaksi[baris][1] = kasir;
                           System.out.println("Kasir \t\t\t\t: " +transaksi[baris][1]);
                           System.out.println("");

                           System.out.print("Cetak Struk? (1. Ya, 2. Tidak) : ");
                           int cetak = input.nextInt();

                           if (cetak==1){
                              kasirr();
                           }
                           baris = baris + 1;
                        }

                        case 3 ->{System.out.println("");}

                        default -> System.out.println("Pilihan menu salah.");
                     }
                  }while(menu!=3);
                  System.out.println("_________________________________________________________________________\n");
               }

               //AKUN ADMIN
               case 2 -> {
                  int menu;
                  System.out.println("_____________________________ADMIN UPN STORE_____________________________");

                  do{
                     System.out.println("1. Review data 2. Tambah Data  3. Hapus Data 4. Ubah Data 5. Keluar Admin");
                     System.out.print("==> Select : ");
                     menu = input.nextInt();
                     System.out.println("");
                     switch(menu){
                        case 1 -> {
                           colsort=0;
                           cetak();
                           System.out.println("");
                        }

                        //TAMBAH DATA
                        case 2 -> {
                           System.out.println("\t\t\t   ---> Tambah Data Barang <---");
                           System.out.print("Kode \t: ");
                           
                           do{
                              ketemu = false;
                              carikode = input.nextInt();
                              searchkode();
                              
                              if(ketemu!=true){
                                 barang[jumlah][0] = carikode;
                                 System.out.print("Nama \t: ");
                                 barang2[jumlah] = input.next();
                                 System.out.print("Harga \t: ");
                                 barang[jumlah][1] = input.nextInt();
                                 System.out.print("Stok \t: ");
                                 barang[jumlah][2] = input.nextInt();                        

                                 jumlah = jumlah + 1;
                              }
                              else{
                                 System.out.print("Kode barang sudah ada, silahkan masukkan kode yang lain : ");
                              }
                           }while(ketemu==true);
                           
                           System.out.println("");
                        }

                        //HAPUS DATA
                        case 3 -> {
                           int x;
                           ketemu=false;

                           System.out.println("\t\t   --->Hapus Data Barang <---");
                           colsort=0;
                           cetak();
                           System.out.print("==> Kode barang yang ingin dihapus : ");
                           carikode = input.nextInt();
                           searchkode();
                           for (x=indeks; x<jumlah; x++){
                              barang[x][0] = barang[x+1][0];
                              barang[x][1] = barang[x+1][1];
                              barang[x][2] = barang[x+1][2];
                              barang2[x]   = barang2[x+1];
                           }

                           barang[jumlah-1][0] = 0;
                           barang[jumlah-1][1] = 0;
                           barang[jumlah-1][2] = 0;
                           barang2[jumlah-1] = "0";

                           if(ketemu!=true){
                              System.out.println("Data tidak ada.");
                           }

                           jumlah = jumlah-1;
                           System.out.println("");
                           colsort=0;
                           System.out.println("");
                        }

                        //MENGUBAH DATA
                        case 4 -> {
                           System.out.println("\t\t\t   ---> Ubah Data <---");
                           System.out.print("==> Nama barang yang akan diubah : ");
                           searchnama();
                           System.out.println("Kode = " +barang[indeks][0]+ "; Nama : " +barang2[indeks]+ "; Harga : " +barang[indeks][1]);
                           barang[indeks][0] = 0;
                           System.out.print("Input kode baru   : ");
                           
                            do{
                              ketemu = false;
                              carikode = input.nextInt();
                              searchkode();
                              
                              if(ketemu!=true){
                                 
                                 barang[indeks][0] = carikode;
                                 System.out.print("Nama Baru   : ");
                                 barang2[indeks] = input.next();
                                 System.out.print("Harga Baru  : ");
                                 barang[indeks][1] = input.nextInt();
                                 System.out.print("Stok Baru   : ");
                                 barang[indeks][2] = input.nextInt();                        

                              }
                              else{
                                 System.out.print("Kode barang sudah ada, silahkan masukkan kode yang lain : ");
                              }
                           }while(ketemu==true);
                            
                           System.out.println("");
                        }

                        case 5 ->{}

                        default -> System.out.println("Pilihan menu salah.");
                     }
                  }while(menu!=5);
                  System.out.println("_________________________________________________________________________\n");
               }

               //AKUN OWNER
               case 3 -> {
                  int menu;
                  System.out.println("_____________________________OWNER UPN STORE_____________________________");
                  do{
                     System.out.println("1. Laporan Penjualan \t2. Barang Terlaris \t3. Keluar Owner");
                     System.out.print("==> Pilih menu : ");
                     menu = input.nextInt();
                     System.out.println("");

                     switch(menu){

                        //Laporan Penjualan
                        case 1 -> {
                           
                           System.out.println("\t\t   ---> Laporan Penjualan <---");
                           System.out.println("Transaksi \tKasir \t\tTotal Harga \tWaktu");
                           for(int c=0; c<baris; c++){
                              System.out.println("Ke-" +(c+1)+ "\t\t"+ transaksi[c][1] +"\t\tRp. "+ hargaa[c][1] +"\t"+ transaksi[c][0]);
                              totalsemua = totalsemua + hargaa[c][1];
                           }
                           System.out.println("--------------------------------------------------------------------");
                           System.out.println(baris + " Transaksi \t\t\tRp. " + totalsemua);
                           System.out.println("");
                        }

                        //Barang Terlaris
                        case 2 -> {
                           colsort=3;
                           sort();

                           System.out.println("\t\t---> Laporan 5 Barang Terlaris <---");
                           System.out.println("Kode \tNama \t\tHarga \t   Stok \tTerjual");

                           for(int i=jumlah-1; i>=jumlah-5; i--){
                              System.out.println(barang[i][0] +"\t"+ barang2[i] +"\t\t"+ barang[i][1] +"\t   "+ barang[i][2] +"\t\t  "+ barang[i][3] );
                           }
                           System.out.println("");
                        }

                        case 3 ->{}

                        default -> System.out.println("Pilihan menu salah.");
                     }
                  }while(menu!=3);
                  System.out.println("_________________________________________________________________________");
               }

               //KELUAR PROGRAM
               case 4 -> {
                  System.out.println("Anda telah keluar dari program.");
                  System.out.println("============================= TERIMA KASIH ==============================");
               }
               default -> System.out.println("Pilihan akun user salah");
            }
         }while(user!=4);
      }
      
      else {
         System.out.println("Login telah gagal 3 kali. Gagal masuk ke program.");
      }
   }
}
