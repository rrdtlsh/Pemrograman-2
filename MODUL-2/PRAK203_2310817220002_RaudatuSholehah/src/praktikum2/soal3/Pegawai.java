package praktikum2.soal3; 

//Mengubah nama kelas dari Employee menjadi Pegawai untuk konsistensi dengan nama file
//public class Employee {
public class Pegawai { 
    public String nama; 
    
    // Pada baris ini terjadi error karena tipe data asal seharusnya String, bukan char.
    // public char asal; 
    public String asal; 
    public String jabatan; 
    public int umur; 

    public String getNama() { 
        return nama; 
    } 

    public String getAsal() { 
        return asal; 
    } 

    // Pada baris ini terjadi error karena parameter 'j' tidak didefinisikan di dalam metode.
    // public void setJabatan() { 
    //     this.jabatan = j; 
    // } 
    public void setJabatan(String j) { 
        this.jabatan = j; 
    } 
    
    // Menambahkan metode getter untuk mengakses nilai umur
    public int getUmur() { 
        return umur; 
    } 
}