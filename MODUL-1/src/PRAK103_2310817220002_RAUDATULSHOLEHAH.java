import java.util.Scanner;

public class PRAK103_2310817220002_RAUDATULSHOLEHAH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan Jumlah bilangan   : ");
        int N = input.nextInt();

        System.out.print("Masukkan bilangan awal     : ");
        int bilanganAwal = input.nextInt();

        int baris = 0;

        System.out.print("Deret bilangan             : ");

        do {
            if (bilanganAwal % 2 != 0) {
                System.out.print(bilanganAwal);
                baris++;
                if (baris < N) {
                    System.out.print(", ");
                }
            }
            bilanganAwal++;
        } while (baris < N);

        input.close();
    }
}