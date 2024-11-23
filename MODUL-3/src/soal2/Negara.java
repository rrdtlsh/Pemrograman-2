package soal2;

import java.util.HashMap;

public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, 
                  int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }

    public String toString(HashMap<Integer, String> bulanMap) {
        StringBuilder sb = new StringBuilder();
        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            sb.append("Negara ").append(nama).append(" mempunyai Raja bernama ").append(namaPemimpin).append("\n");
        } else {
            String bulan = bulanMap.get(bulanKemerdekaan);
            sb.append("Negara ").append(nama)
              .append(" mempunyai ")
              .append(jenisKepemimpinan.equalsIgnoreCase("presiden") ? "Presiden" : "Perdana Menteri")
              .append(" bernama ").append(namaPemimpin).append("\n")
              .append("Deklarasi Kemerdekaan pada Tanggal ").append(tanggalKemerdekaan).append(" ")
              .append(bulan).append(" ").append(tahunKemerdekaan).append("\n");
        }
        return sb.toString();
    }
}