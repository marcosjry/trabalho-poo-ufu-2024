package personal.management.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personal.management.system.graphic.controllers.login.LoginController;


import java.io.IOException;
import java.net.URL;

public class Initiate extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {

            // Carrega o FXML da tela de login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal/management/system/LoginScreen.fxml")); // Substitua pelo caminho correto do seu FXML
            Parent root = loader.load();

            // Injeta o primaryStage no controlador de login
            LoginController loginController = loader.getController();
            loginController.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setMinWidth(780);
            primaryStage.setMinHeight(460);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Tela de Login");
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}