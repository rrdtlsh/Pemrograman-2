package soal1;

import java.util.Scanner;

public class Mainsoal1 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String namaHewan = scanner.nextLine();

        System.out.print("Ras: ");
        String rasHewan = scanner.nextLine();

        HewanPeliharaan hewan = new HewanPeliharaan(rasHewan, namaHewan);

        hewan.display();

        scanner.close();
    }
}