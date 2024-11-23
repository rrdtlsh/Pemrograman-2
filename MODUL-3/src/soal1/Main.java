package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dadu dd = new Dadu();

        System.out.print("Masukkan jumlah dadu: ");
        int masukkan = input.nextInt();
        dd.setInput(masukkan);
        dd.acakNilai();
    }
}