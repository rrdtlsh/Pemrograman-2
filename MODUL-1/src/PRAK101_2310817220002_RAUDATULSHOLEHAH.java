import java.util.Scanner;

public class PRAK101_2310817220002_RAUDATULSHOLEHAH {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap Anda      : ");
        String namaLengkap = input.nextLine();

        System.out.print("Masukkan Tempat Kelahiran Anda  : ");
        String tempatLahir = input.nextLine();

        System.out.print("Masukkan Tanggal Kelahiran Anda : ");
        int tanggalLahir = input.nextInt();

        System.out.print("Masukkan Bulan Kelahiran Anda   : ");
        int bulanLahir = input.nextInt();

        System.out.print("Masukkan Tahun Kelahiran Anda   : ");
        int tahunLahir = input.nextInt();

        input.nextLine();

        System.out.print("Masukkan Tinggi Badan Anda (cm) : ");
        int tinggiBadan = input.nextInt();

        input.nextLine();

        System.out.print("Masukkan Berat Badan Anda (kg)  : ");
        String beratBadanStr = input.nextLine().replace(",", ".");
        double beratBadan = Double.parseDouble(beratBadanStr);

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.println("\nHalo, Nama Saya " + namaLengkap + ". Saya lahir di " + tempatLahir + " pada tanggal " + tanggalLahir + " " + namaBulan[bulanLahir - 1] + " " + tahunLahir + ".");
        System.out.println("Tinggi badan saya " + tinggiBadan + " cm dan berat badan saya " + beratBadan + " kilogram.");

        input.close();
    }
}