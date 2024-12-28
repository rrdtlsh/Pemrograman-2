package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Muat file FXML
        	TabPane root = FXMLLoader.load(getClass().getResource("MainView.fxml"));

            // Atur scene dan stage
            Scene scene = new Scene(root);
            primaryStage.setTitle("Manajemen Penjualan Buku");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}