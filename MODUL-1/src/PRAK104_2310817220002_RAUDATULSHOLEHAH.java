import java.util.Scanner;

public class PRAK104_2310817220002_RAUDATULSHOLEHAH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Tangan Abu   : ");
        String tanganAbu = input.nextLine();

        System.out.print("Tangan Bagas : ");
        String tanganBagas = input.nextLine();

        String[] tanganAbuArr = tanganAbu.split(" ");
        String[] tanganBagasArr = tanganBagas.split(" ");

        int poinAbu = 0;
        int poinBagas = 0;

        for (int i = 0; i < 3; i++) {
            char tanganAbuRonde = tanganAbuArr[i].charAt(0);
            char tanganBagasRonde = tanganBagasArr[i].charAt(0);

            if (tanganAbuRonde == tanganBagasRonde) {
 
            } else if ((tanganAbuRonde == 'B' && tanganBagasRonde == 'G') ||
                       (tanganAbuRonde == 'G' && tanganBagasRonde == 'K') ||
                       (tanganAbuRonde == 'K' && tanganBagasRonde == 'B')) {
                poinAbu++;
            } else {
                poinBagas++;
            }
        }

        if (poinAbu > poinBagas) {
            System.out.println("Pemenangnya adalah Abu");
        } else if (poinBagas > poinAbu) {
            System.out.println("Pemenangnya adalah Bagas");
        } else {
            System.out.println("Hasilnya Seri");
        }

        input.close();
    }
}