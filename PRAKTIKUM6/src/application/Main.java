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

        TableColumn<Mahasiswa, String> kolomNIM = new TableColumn<>("NIM");
        kolomNIM.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));

        tabelMahasiswa.getColumns().addAll(kolomNIM, kolomNama);

        tabelMahasiswa.getItems().addAll(
                new Mahasiswa(1, "Raudatul Sholehah", "2310817220002"),
                new Mahasiswa(2, "Zahra Nabila", "2310817320007"),
                new Mahasiswa(3, "Nur Hikmah", "2310817120010"),
                new Mahasiswa(4, "Dina Izzati Elfadheya", "2310817120001"),
                new Mahasiswa(5, "Sheila Sabina", "2310817220028"),
                new Mahasiswa(6, "Aliya Raffa Naura Ayu", "2310817120014"),
                new Mahasiswa(7, "Muhammad Rizki Ramadhan", "2310817310008"),
                new Mahasiswa(8, "Muhammad Hasbiyan Rusyadi", "2310817210020"),
                new Mahasiswa(9, "Muhammad Erza Raihan", "2310817210027"),
                new Mahasiswa(10, "Andra Braputra Akbar Saleh", "2310817210001")
        );

        VBox vbox = new VBox(tabelMahasiswa);

        Scene scene = new Scene(vbox);
        panggungUtama.setScene(scene);

        panggungUtama.show();
    }
}