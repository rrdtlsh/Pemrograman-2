package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;
import java.time.LocalDate;

public class Controllerprak7 {

    @FXML private TextField namaField, emailField, teleponField;
    @FXML private TableView<Pelanggan> pelangganTable;
    @FXML private TableColumn<Pelanggan, String> namaColumn, emailColumn, teleponColumn;
    @FXML private Button addPelanggan, editPelanggan, deletePelanggan;

    @FXML private TextField judulField, penulisField, hargaField, stokField;
    @FXML private TableView<Buku> bukuTable;
    @FXML private TableColumn<Buku, String>judulColumn, penulisColumn;
    @FXML private TableColumn<Buku, Double> hargaColumn;
    @FXML private TableColumn<Buku, Integer> stokColumn;
    @FXML private Button addBuku, editBuku, deleteBuku;

    @FXML private ComboBox<Pelanggan> pelangganComboBox;
    @FXML private ComboBox<Buku> bukuComboBox;
    @FXML private TextField jumlahField;
    @FXML private DatePicker tanggalPicker;
    @FXML private TableView<Penjualan> penjualanTable;
    @FXML private TableColumn<Penjualan, String> pelangganColumn, bukuColumn;
    @FXML private TableColumn<Penjualan, Integer> jumlahColumn;
    @FXML private TableColumn<Penjualan, Double> totalHargaColumn;
    @FXML private TableColumn<Penjualan, Date> tanggalColumn;
    @FXML private Button addPenjualan, editPenjualan, deletePenjualan;

    private ObservableList<Pelanggan> pelangganList = FXCollections.observableArrayList();
    private ObservableList<Buku> bukuList = FXCollections.observableArrayList();
    private ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();
    private Connection connection;

    @FXML
    public void initialize() {
        connectDatabase();
        setupColumns();
        setupComboBoxFactories(); 
        loadData();
    }

    private void setupComboBoxFactories() {
    	pelangganComboBox.setCellFactory(param -> new ListCell<>() {
    	    @Override
    	    protected void updateItem(Pelanggan item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (empty || item == null) {
    	            setText(null);
    	        } else {
    	            setText(item.getNama().get());
    	        }
    	    }
    	});

    	pelangganComboBox.setButtonCell(new ListCell<>() {
    	    @Override
    	    protected void updateItem(Pelanggan item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (empty || item == null) {
    	            setText(null);
    	        } else {
    	            setText(item.getNama().get());
    	        }
    	    }
    	});

    	bukuComboBox.setCellFactory(param -> new ListCell<>() {
    	    @Override
    	    protected void updateItem(Buku item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (empty || item == null) {
    	            setText(null);
    	        } else {
    	            setText(item.getJudul().get());
    	        }
    	    }
    	});

    	bukuComboBox.setButtonCell(new ListCell<>() {
    	    @Override
    	    protected void updateItem(Buku item, boolean empty) {
    	        super.updateItem(item, empty);
    	        if (empty || item == null) {
    	            setText(null);
    	        } else {
    	            setText(item.getJudul().get());
    	        }
    	    }
    	});
    }

    private void connectDatabase() {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupColumns() {
        namaColumn.setCellValueFactory(data -> data.getValue().getNama());
        emailColumn.setCellValueFactory(data -> data.getValue().getEmail());
        teleponColumn.setCellValueFactory(data -> data.getValue().getTelepon());

        judulColumn.setCellValueFactory(data -> data.getValue().getJudul());
        penulisColumn.setCellValueFactory(data -> data.getValue().getPenulis());
        hargaColumn.setCellValueFactory(data -> data.getValue().getHarga().asObject());
        stokColumn.setCellValueFactory(data -> data.getValue().getStok().asObject());

        pelangganColumn.setCellValueFactory(data -> data.getValue().getPelanggan_id());
        bukuColumn.setCellValueFactory(data -> data.getValue().getBuku_id());
        jumlahColumn.setCellValueFactory(data -> data.getValue().getJumlah().asObject());
        totalHargaColumn.setCellValueFactory(data -> data.getValue().getTotalHarga().asObject());
        tanggalColumn.setCellValueFactory(data -> data.getValue().getTanggal());
    }

    private void loadData() {
        loadPelangganData();
        loadBukuData();
        loadPenjualanData();
    }

    private void loadPelangganData() {
    	    pelangganList.clear();
    	    try (Statement stmt = connection.createStatement()) {
    	        ResultSet rs = stmt.executeQuery("SELECT * FROM pelanggan");
    	        while (rs.next()) {
    	            pelangganList.add(new Pelanggan(
    	                rs.getString("pelanggan_id"),
    	                rs.getString("Nama"),
    	                rs.getString("Email"),
    	                rs.getString("Telepon")
    	            ));
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    pelangganComboBox.setItems(pelangganList);
    	    pelangganTable.setItems(pelangganList);
    	}

    private void loadBukuData() {
        bukuList.clear();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM buku");
            while (rs.next()) {
                bukuList.add(new Buku(
                    rs.getString("buku_id"),
                    rs.getString("Judul"),
                    rs.getString("Penulis"),
                    rs.getDouble("Harga"),
                    rs.getInt("Stok")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bukuComboBox.setItems(bukuList);
        bukuTable.setItems(bukuList);
    }

    private void loadPenjualanData() {
        penjualanList.clear();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM penjualan");
            while (rs.next()) {
                penjualanList.add(new Penjualan(
                    rs.getString("penjualan_id"),
                    rs.getString("pelanggan_id"),
                    rs.getString("buku_id"),
                    rs.getInt("Jumlah"),
                    rs.getDouble("Total_harga"),
                    rs.getDate("Tanggal")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        penjualanTable.setItems(penjualanList);
    }

    @FXML
    private void handleAddPelanggan() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO pelanggan (Nama, Email, Telepon) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, namaField.getText());
            stmt.setString(2, emailField.getText());
            stmt.setString(3, teleponField.getText());
            stmt.executeUpdate();
            loadPelangganData();
            clearPelangganFields();
            showPelangganAlert(AlertType.INFORMATION, "Pelanggan ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditPelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE pelanggan SET Nama = ?, Email = ?, Telepon = ? WHERE pelanggan_id = ?")) {
                stmt.setString(1, namaField.getText());
                stmt.setString(2, emailField.getText());
                stmt.setString(3, teleponField.getText());
                stmt.setString(4, selected.getPelangganId());
                stmt.executeUpdate();
                loadPelangganData();
                clearPelangganFields();
                showPelangganAlert(AlertType.INFORMATION, "Pelanggan diperbarui.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleDeletePelanggan() {
        Pelanggan selected = pelangganTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM pelanggan WHERE pelanggan_id = ?")) {
                stmt.setString(1, selected.getPelangganId());
                stmt.executeUpdate();
                loadPelangganData();
                showPelangganAlert(AlertType.INFORMATION, "Pelanggan dihapus.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleAddBuku() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO buku (Judul, Penulis, Harga, Stok) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, judulField.getText());
            stmt.setString(2, penulisField.getText());
            stmt.setDouble(3, Double.parseDouble(hargaField.getText()));
            stmt.setInt(4, Integer.parseInt(stokField.getText()));
            stmt.executeUpdate();
            loadBukuData();
            clearBukuFields();
            showBukuAlert(AlertType.INFORMATION, "Buku ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE buku SET Judul = ?, Penulis = ?, Harga = ?, Stok = ? WHERE buku_id = ?")) {
                stmt.setString(1, judulField.getText());
                stmt.setString(2, penulisField.getText());
                stmt.setDouble(3, Double.parseDouble(hargaField.getText()));
                stmt.setInt(4, Integer.parseInt(stokField.getText()));
                stmt.setString(5, selected.getBukuId());
                stmt.executeUpdate();
                loadBukuData();
                clearBukuFields();
                showBukuAlert(AlertType.INFORMATION, "Buku diperbarui.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleDeleteBuku() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM buku WHERE buku_id = ?")) {
                stmt.setString(1, selected.getBukuId());
                stmt.executeUpdate();
                loadBukuData();
                showBukuAlert(AlertType.INFORMATION, "Buku dihapus.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleAddPenjualan() {
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO penjualan (pelanggan_id, buku_id, Jumlah, Total_harga, Tanggal) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pelangganComboBox.getValue().getPelangganId());
            stmt.setString(2, bukuComboBox.getValue().getBukuId());
            stmt.setInt(3, Integer.parseInt(jumlahField.getText()));
            stmt.setDouble(4, Double.parseDouble(jumlahField.getText()) * bukuComboBox.getValue().getHarga().get());
            stmt.setDate(5, Date.valueOf(tanggalPicker.getValue()));
            stmt.executeUpdate();
            loadPenjualanData();
            clearPenjualanFields();
            showPenjualanAlert(AlertType.INFORMATION, "Penjualan ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditPenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE penjualan SET pelanggan_id = ?, buku_id = ?, Jumlah = ?, Total_harga = ?, Tanggal = ? WHERE penjualan_id = ?")) {
                stmt.setString(1, pelangganComboBox.getValue().getPelangganId());
                stmt.setString(2, bukuComboBox.getValue().getBukuId());
                stmt.setInt(3, Integer.parseInt(jumlahField.getText()));
                stmt.setDouble(4, Double.parseDouble(jumlahField.getText()) * bukuComboBox.getValue().getHarga().get());
                stmt.setDate(5, Date.valueOf(tanggalPicker.getValue()));
                stmt.setString(6, selected.getPenjualanId());
                stmt.executeUpdate();
                loadPenjualanData();
                clearPenjualanFields();
                showPenjualanAlert(AlertType.INFORMATION, "Penjualan diperbarui.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleDeletePenjualan() {
        Penjualan selected = penjualanTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM penjualan WHERE penjualan_id = ?")) {
                stmt.setString(1, selected.getPenjualanId());
                stmt.executeUpdate();
                loadPenjualanData();
                showPenjualanAlert(AlertType.INFORMATION, "Penjualan dihapus.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            showPenjualanAlert(AlertType.WARNING, "Tidak ada data penjualan yang dipilih untuk dihapus.");
        }
    }

    private void showPelangganAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showBukuAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showPenjualanAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handletanggal() {
        LocalDate selectedDate = tanggalPicker.getValue();
        if (selectedDate != null) {
            System.out.println("Selected Date: " + selectedDate);
        }
    }
    
    private void clearPelangganFields() {
        namaField.clear();
        emailField.clear();
        teleponField.clear();
    }

    private void clearBukuFields() {
        judulField.clear();
        penulisField.clear();
        hargaField.clear();
        stokField.clear();
    }

    private void clearPenjualanFields() {
        pelangganComboBox.getSelectionModel().clearSelection();
        bukuComboBox.getSelectionModel().clearSelection();
        jumlahField.clear();
        tanggalPicker.setValue(null);
    }

}