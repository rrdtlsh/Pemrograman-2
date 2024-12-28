package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Buku {
    private StringProperty buku_id;
    private final StringProperty judul;
    private final StringProperty penulis;
    private final SimpleDoubleProperty harga;
    private final SimpleIntegerProperty stok;

    public Buku(String buku_id, String judul, String penulis, double harga, int stok) {
        this.buku_id = new SimpleStringProperty(buku_id);
        this.judul = new SimpleStringProperty(judul);
        this.penulis = new SimpleStringProperty(penulis);
        this.harga = new SimpleDoubleProperty(harga);
        this.stok = new SimpleIntegerProperty(stok);
    }

    public StringProperty buku_idProperty() { return new SimpleStringProperty(buku_id.get()); }
    public String getBukuId() { return buku_id.get(); }
    public void setBukuId(String bukuId) { this.buku_id.set(bukuId); }
    public StringProperty getJudul() { return judul; }
    public StringProperty getPenulis() { return penulis; }
    public SimpleDoubleProperty getHarga() { return harga; }
    public SimpleIntegerProperty getStok() { return stok; }
}