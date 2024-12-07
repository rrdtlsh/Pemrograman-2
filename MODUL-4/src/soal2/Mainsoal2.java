package soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Mainsoal2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                Pilih jenis hewan yang ingin diinputkan:
                1 = Kucing
                2 = Anjing
                Masukkan pilihan:""");
        int pilihan = in.nextInt();
        in.nextLine();
        inputOutput(pilihan, in);
    }
    static private void inputOutput(int pilihan, Scanner in) {
        System.out.print("Nama hewan peliharaan : ");
        String nama = in.nextLine();
        System.out.print("Ras : ");
        String ras = in.nextLine();
        System.out.print("Warna Bulu : ");
        String warnaBulu = in.nextLine();
        if (pilihan == 1) {
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            System.out.println();
            kucing.displayDetailKucing();
        } else if (pilihan == 2) {
            ArrayList<String> kemampuanList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                System.out.print("Kemampuan " + (i + 1) + ": ");
                String kemampuan = in.nextLine().trim();
                if (!kemampuan.isEmpty()) {
                    kemampuanList.add(kemampuan);
                } else {
                    System.out.println("Input kosong, hentikan pengisian lebih awal.");
                    break;
                }
            }
            String[] kemampuanArray = kemampuanList.toArray(new String[0]);
            Anjing anjing = new Anjing(ras, nama, warnaBulu, kemampuanArray);
            System.out.println();
            anjing.displayDetailAnjing();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
