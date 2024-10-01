import java.util.Scanner;

public class PRAK105_2310817220002_RAUDATULSHOLEHAH {
	public static void main(String[] args) {
        final double PHI = 3.14;
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari : ");
        double jariJari = input.nextDouble();

        System.out.print("Masukkan tinggi    : ");
        double tinggi = input.nextDouble();

        double volume = PHI * Math.pow(jariJari, 2) * tinggi;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3%n", jariJari, tinggi, volume/10000);

        input.close();
    }
}