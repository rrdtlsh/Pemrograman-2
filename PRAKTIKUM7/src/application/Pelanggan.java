package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
	private StringProperty pelanggan_id;
    private final StringProperty nama;
    private final StringProperty email;
    private final StringProperty telepon;

    // Konstruktor
    public Pelanggan(String pelanggan_id, String nama, String email, String telepon) {
        this.pelanggan_id = new SimpleStringProperty(pelanggan_id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public StringProperty pelanggan_idProperty() { return pelanggan_id; }
    public String getPelangganId() { return pelanggan_id.get(); }
    public void setPelangganId(String pelanggan_id) { this.pelanggan_id.set(pelanggan_id); }

	public StringProperty getNama() {
		return nama;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getTelepon() {
		return telepon;
	}
    
}