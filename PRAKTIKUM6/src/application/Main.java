package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage panggungUtama) {

        TableView<Mahasiswa> tabelMahasiswa = new TableView<>();

        // Kolom ID
        TableColumn<Mahasiswa, Integer> kolomID = new TableColumn<>("ID");
        kolomID.setCellValueFactory(new PropertyValueFactory<>("id"));

        // Kolom NIM
        TableColumn<Mahasiswa, String> kolomNIM = new TableColumn<>("NIM");
        kolomNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));

        // Kolom Nama
        TableColumn<Mahasiswa, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tabelMahasiswa.getColumns().addAll(kolomID, kolomNIM, kolomNama);

        tabelMahasiswa.getItems().addAll(
                new Mahasiswa(1, "2310817220002", "Raudatul Sholehah"),
                new Mahasiswa(2, "2310817320007", "Zahra Nabila"),
                new Mahasiswa(3, "2310817120010", "Nur Hikmah"),
                new Mahasiswa(4, "2310817120001", "Dina Izzati Elfadheya"),
                new Mahasiswa(5, "2310817220028", "Sheila Sabina"),
                new Mahasiswa(6, "2310817120014", "Aliya Raffa Naura Ayu"),
                new Mahasiswa(7, "2310817310008", "Muhammad Rizki Ramadhan"),
                new Mahasiswa(8, "2310817210020", "Muhammad Hasbiyan Rusyadi"),
                new Mahasiswa(9, "2310817210027", "Muhammad Erza Raihan"),
                new Mahasiswa(10, "2310817210001", "Andra Braputra Akbar Saleh")
        );

        VBox vbox = new VBox(tabelMahasiswa);

        Scene scene = new Scene(vbox);
        panggungUtama.setScene(scene);

        panggungUtama.setTitle("Tabel Mahasiswa");
        panggungUtama.show();
    }
}