import java.util.Scanner;

public class PRAK102_2310817220002_RAUDATULSHOLEHAH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Input   : ");
        int angkaAwal = input.nextInt();
        int jumlahDeret = 10;
        int count = 0;

        System.out.print("Output  : ");
        
        while (count < jumlahDeret) {
            int angka;
            if (angkaAwal % 5 == 0) {
                angka = (angkaAwal / 5) - 1;
            } else {
                angka = angkaAwal;
            }

            System.out.print(angka);
            count++;

            if (count < jumlahDeret) {
                System.out.print(", ");
            }

            angkaAwal++;
        }

        input.close();
    }
}