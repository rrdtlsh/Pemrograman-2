package soal2;

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
            System.out.print("Memiliki kemampuan : ");
            String[] kemampuan = in.nextLine().split(", ");
            Anjing anjing = new Anjing(ras, nama, warnaBulu, kemampuan);
            System.out.println();
            anjing.displayDetailAnjing();
        }
    }
}