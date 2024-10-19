package praktikum2.soal1;

class Buah {
    String nama; 
    double beratPerUnit;
    double hargaPerUnit;
    double jumlahBeli;
    double hargaSebelumDiskon;
    double totalDiskon; 
    double hargaSetelahDiskon;

    public Buah(String nama, double beratPerUnit, double hargaPerUnit, double jumlahBeli) { 
        this.nama = nama; 
        this.beratPerUnit = beratPerUnit; 
        this.hargaPerUnit = hargaPerUnit; 
        this.jumlahBeli = jumlahBeli;
        this.hargaSebelumDiskon = (jumlahBeli / beratPerUnit) * hargaPerUnit;
    } 

    public void hitungTotalDiskon() { 
    	 totalDiskon = (Math.floor(jumlahBeli / 4) * 0.02 * hargaPerUnit * 4);
    	 hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon; 
    	 
    } 

    public void buahInfo() { 
        System.out.println("Nama Buah           : " + nama); 
        System.out.println("Berat               : " + beratPerUnit + "kg"); 
        System.out.println("Harga               : Rp" + hargaPerUnit); 
        System.out.println("Jumlah Beli         : " + jumlahBeli + "kg"); 
        System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", hargaSebelumDiskon); 
        
        hitungTotalDiskon(); 
        System.out.printf("Total Diskon        : Rp%.2f\n", totalDiskon); 
        System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", hargaSetelahDiskon); 
    } 
}