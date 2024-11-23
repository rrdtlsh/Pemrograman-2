package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Negara> negaraList = new LinkedList<>();
        HashMap<Integer, String> bulanMap = new HashMap<>();

        bulanMap.put(1, "Januari");
        bulanMap.put(2, "Februari");
        bulanMap.put(3, "Maret");
        bulanMap.put(4, "April");
        bulanMap.put(5, "Mei");
        bulanMap.put(6, "Juni");
        bulanMap.put(7, "Juli");
        bulanMap.put(8, "Agustus");
        bulanMap.put(9, "September");
        bulanMap.put(10, "Oktober");
        bulanMap.put(11, "November");
        bulanMap.put(12, "Desember");

        System.out.print("Masukkan jumlah negara: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("Masukkan data untuk negara ke-" + i + ":");

            System.out.print("Nama Negara           : ");
            String nama = sc.nextLine();

            System.out.print("Jenis Kepemimpinan (monarki/presiden/perdana menteri): ");
            String jenisKepemimpinan = sc.nextLine();

            System.out.print("Nama Pemimpin         : ");
            String namaPemimpin = sc.nextLine();

            int tanggalKemerdekaan = 0, bulanKemerdekaan = 0, tahunKemerdekaan = 0;
            if (!jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                System.out.print("Tanggal Kemerdekaan   : ");
                tanggalKemerdekaan = Integer.parseInt(sc.nextLine());

                System.out.print("Bulan Kemerdekaan (angka 1-12): ");
                bulanKemerdekaan = Integer.parseInt(sc.nextLine());

                System.out.print("Tahun Kemerdekaan     : ");
                tahunKemerdekaan = Integer.parseInt(sc.nextLine());
            }

            Negara negara = new Negara(
                nama, 
                jenisKepemimpinan, 
                namaPemimpin, 
                tanggalKemerdekaan, 
                bulanKemerdekaan, 
                tahunKemerdekaan
            );
            negaraList.add(negara);
        }

        System.out.println("\nDetail Negara yang Dimasukkan:");
        for (Negara negara : negaraList) {
            System.out.println(negara.toString(bulanMap));
        }

        sc.close();
    }
}