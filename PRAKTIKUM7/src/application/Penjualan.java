package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.Date;

public class Penjualan {
    private final StringProperty penjualan_id;
    private final StringProperty pelanggan_id;
    private final StringProperty buku_id;
    private final SimpleIntegerProperty jumlah;
    private final SimpleDoubleProperty totalHarga;
    private final ObjectProperty<Date> tanggal;

    // Constructor
    public Penjualan(String penjualan_id, String pelanggan_id, String buku_id, int jumlah, double totalHarga, Date tanggal) {
        this.penjualan_id = new SimpleStringProperty(penjualan_id);
        this.pelanggan_id = new SimpleStringProperty(pelanggan_id);
        this.buku_id = new SimpleStringProperty(buku_id);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.totalHarga = new SimpleDoubleProperty(totalHarga);
        this.tanggal = new SimpleObjectProperty<>(tanggal);
    }

    public StringProperty penjualan_idProperty() { return penjualan_id; }
    public String getPenjualanId() { return penjualan_id.get(); }
    public void setPenjualanId(String penjualan_id) { this.penjualan_id.set(penjualan_id); }

	public StringProperty getPelanggan_id() {
		return pelanggan_id;
	}

	public StringProperty getBuku_id() {
		return buku_id;
	}

	public SimpleIntegerProperty getJumlah() {
		return jumlah;
	}

	public SimpleDoubleProperty getTotalHarga() {
		return totalHarga;
	}

	public ObjectProperty<Date> getTanggal() {
		return tanggal;
	}
}