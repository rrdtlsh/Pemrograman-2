package praktikum2.soal3; 
 
public class Soal3Main { 
    public static void main(String[] args) { 
        Pegawai p1 = new Pegawai(); 
        // Pada baris ini terjadi error karena kurangnya titik koma (;) di akhir baris.
        // p1.nama = "Roi" 
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel"; 
        p1.setJabatan("Assasin"); 
        // Menambahkan nilai
        p1.umur = 17; // Pastikan untuk mengisi umur terlebih dahulu
 
        System.out.println("Nama         : " + p1.getNama()); 
        System.out.println("Asal         : " + p1.getAsal()); 
        System.out.println("Jabatan      : " + p1.jabatan); 
        // Menambahkan kata "tahun" di akhir untuk menunjukkan satuan waktu
        // System.out.println("Umur: " + p1.umur);
        System.out.println("Umur         : " + p1.umur + " tahun"); 
    } 
}