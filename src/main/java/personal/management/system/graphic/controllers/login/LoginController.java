package personal.management.system.graphic.controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import personal.management.system.graphic.controllers.home.HomeController;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField pwBox;

    private Stage primaryStage;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = userTextField.getText();
        String password = pwBox.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campos vazios", "Por favor, preencha todos os campos.");
            return;
        }

        if (username.equals("admin") && password.equals("1234")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal/management/system/HomeScreen.fxml")); // Substitua pelo nome correto do seu FXML
                Parent root = loader.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Tela Principal");


                HomeController nextController = loader.getController();
                nextController.setPrimaryStage(primaryStage);


            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Erro ao carregar a tela principal", "Ocorreu um erro ao carregar a próxima tela.");
            }
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}