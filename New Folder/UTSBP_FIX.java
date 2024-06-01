/*
KELOMPOK UTS BP KELAS PARALEL D
Anggota : 
1. Betari Safira Rachmanda      / 22082010140
2. Muhammad Farhan Hidayatullah / 22082010141
3. Iluh Meiranda Dyah Setyawati / 22082010150
4. Fathimatus Zahrotun Nisa'    / 22082010156
5. Daffa Ahmad Baihaqi          / 22082010162

*/

package uts_bp;
import java.util.Scanner;
public class UTSBP_FIX {
public static void main(String[] args) {
        
        //PROGRAM SISTEM PERAMALAN//
        
        Scanner scn = new Scanner(System.in);
        //ULANG
        int ulang;
        
        System.out.println("SELAMAT DATANG DI PROGRAM PERAMALAN DATA PENJUALAN SEDERHANA\n");

        do {
        //INPUT DATA
        System.out.print("Masukkan jumlah bulan/Periode : ");
        int bulan = scn.nextInt();
        int data[] = new int[bulan];
        
        for (int i=0; i<bulan; i++) {
            System.out.print("Data Penjualan bulan ke-" + (i+1) + " : ");
            data[i] = scn.nextInt();
        }
        //TAMPILAN DATA
         System.out.println("----------------------------------\n"
                 + "----------------------------------\n"
                 + "Tampilan Data Penjualan : ");
         for (int i=0; i<bulan; i++) {
            System.out.println("Data Penjualan bulan ke-" + (i+1) + " : " + data[i]);
            
        }
        System.out.println("---------------------------------------------\n"
                 + "---------------------------------------------\n");
        
        //PERAMALAN ORDE 2
        
        System.out.println("PERAMALAN ORDE 2 BULAN :");
        int ramalan = bulan+1;
        int[] peramalan2 = new int[ramalan];
        float[] dev2 = new float[ramalan];
        float jumlahDev2=0;

         for (int j=2; j<bulan; j++) {
             peramalan2[j] = (data[j-2] + data[j-1]) / 2;
             float selisih =Math.abs(data[j] - peramalan2[j]);
             dev2[j] = selisih/data[j]*100;
             
             System.out.println("Data bulan ke-" + (j+1) + " || Unit Terjual = " + data[j] + " | Data Ramalan = " + peramalan2[j] + "| Relative Deviation = " + dev2[j] + "%");
             
             jumlahDev2 = jumlahDev2 + dev2[j];
           
        }
        
         //PERAMALAN ORDE 3
         System.out.println("--------------------------------------------------------------------------------------------------");
         System.out.println("PERAMALAN ORDE 3 BULAN : ");
       
        int[] peramalan3 = peramalan3 = new int[ramalan];
        float[] dev3 = new float[ramalan];
        float jumlahDev3=0;

         for (int j=3; j<bulan; j++) {
             peramalan3[j] = (data[j-3] + data[j-2] + data[j-1]) / 3;
             float selisih =Math.abs( data[j] - peramalan3[j]);
             dev3[j] = selisih/data[j]*100;
            
             System.out.println("Data bulan ke-" + (j+1) + " || Unit Terjual = " + data[j] + " | Data Ramalan = " + peramalan3[j] + "| Relative Deviation = " + dev3[j] + "%");
             
             jumlahDev3 = jumlahDev3 + dev3[j];
            
        }
        
         //PERAMALAN ORDE 4
          System.out.println("--------------------------------------------------------------------------------------------------");
          System.out.println("PERAMALAN ORDE 4 BULAN : ");
       
        int[] peramalan4 = new int[ramalan];
        float[] dev4 = new float[ramalan];
        float jumlahDev4=0;

         for (int j=4; j<bulan; j++) {
             peramalan4[j] = (data[j-4] + data[j-3] + data[j-2] + data[j-1]) / 4;
             float selisih =Math.abs( data[j] - peramalan4[j]);
             dev4[j] = selisih/data[j]*100;
             
             System.out.println("Data bulan ke-" + (j+1) + " || Unit Terjual = " + data[j] + " | Data Ramalan = " + peramalan4[j] + "| Relative Deviation = " + dev4[j] + "%");
             
             jumlahDev4 = jumlahDev4 + dev4[j];  
             
        }
         
         System.out.println("---------------------------------------------\n"
                 + "---------------------------------------------\n");
         
        //TOTAL RELATIVE DEVIATION
        
        System.out.println("Jadi Total Relative Deviation Masing Masing Orde adalah : ");
        dev2[bulan] = jumlahDev2/(bulan-2);
        System.out.println("Orde 2 Bulan");
        System.out.println("Total Relative Deviation Untuk Orde 2 : " + dev2[bulan] + "%");
        dev3[bulan] = jumlahDev3/(bulan-3);
        System.out.println("Orde 3 Bulan");
        System.out.println("Total Relative Deviation Untuk Orde 3 : " + dev3[bulan] + "%");
        dev4[bulan] = jumlahDev4/(bulan-4);
        System.out.println("Orde 4 Bulan");
        System.out.println("Total Relative Deviation Untuk Orde 4 : " + dev4[bulan] + "%");
        System.out.println("------------------------------------------------------------");
        
        //PERAMALAN PERIODE SELANJUTNYA
        peramalan2[bulan] = (data[bulan-2] + data[bulan-1])/2;
        peramalan3[bulan] = (data[bulan-3] + data[bulan-2] + data[bulan-1])/3;
        peramalan4[bulan] = (data[bulan-4] + data[bulan-3] + data[bulan-2] + data[bulan-1])/3;
        
    
        
        //MEMBANDINGKAN RELATIVE DEVIATION
        if (dev2[bulan] < dev3[bulan] && dev2[bulan] < dev4[bulan]) {
            System.out.println("Karena Nilai Relative Deviation yang terkecil adalah yang Orde 2 Bulan yaitu " + dev2[bulan] + " % Maka yang dipilih adalah data peramalan dengan Orde 2 Bulan. Dengan Demikian pada bulan ke-" + ramalan + " jumlah unit yang terjual diperkirakan sejumlah " + peramalan2[bulan] + " unit.");
        } 
        else if (dev3[bulan] < dev2[bulan] && dev3[bulan] < dev4[bulan]) {
            System.out.println("Karena Nilai Relative Deviation yang terkecil adalah yang Orde 3 Bulan yaitu " + dev3[bulan] + " % Maka yang dipilih adalah data peramalan dengan Orde 3 Bulan. Dengan Demikian pada bulan ke-" + ramalan + " jumlah unit yang terjual diperkirakan sejumlah " + peramalan3[bulan] + " unit.");
        }
        else if (dev4[bulan] < dev2[bulan] && dev4[bulan] < dev3[bulan]) {
            System.out.println("Karena Nilai Relative Deviation yang terkecil adalah yang Orde 4 Bulan yaitu " + dev4[bulan] + " % Maka yang dipilih adalah data peramalan dengan Orde 4 Bulan. Dengan Demikian pada bulan ke-" + ramalan + " jumlah unit yang terjual diperkirakan sejumlah " + peramalan4[bulan] + " unit.");
        }
        
        
        System.out.println("\nApakah anda ingin menjalankan program kembali (1/0) ?");
        ulang = scn.nextInt();
        }
        
        while(ulang == 1);
        
        }
    }
        

