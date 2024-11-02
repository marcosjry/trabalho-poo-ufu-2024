package personal.management.system.graphic.controllers.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import personal.management.system.graphic.controllers.home.HomeController;
import personal.management.system.graphic.controllers.register.RegisterController;
import personal.management.system.models.LerEscrever;
import personal.management.system.models.User;
import personal.management.system.services.ServicoUsuario;
import personal.management.system.services.impl.ServicoUsuarioImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginController extends LerEscrever {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField pwBox;

    private Stage primaryStage;

    private ServicoUsuario servicoUsuario = new ServicoUsuarioImpl();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleLogin() throws Exception {

        String userEmail = userTextField.getText();
        String password = pwBox.getText();

        User userToLogin = new User();
        userToLogin.setEmail(userEmail);
        userToLogin.setSenha(password);

        System.out.println(userToLogin.getEmail());
        System.out.println(userToLogin.getSenha());

        archiveSave(servicoUsuario.getUsuarios());

        System.out.println(servicoUsuario.logarUsuario(userToLogin));
         //Seta a lista de usuários a partir do arquivo de registro

        if (servicoUsuario.logarUsuario(userToLogin)) {
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
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro no Login", "Usuário não encontrado.");
        }
    }

    @FXML
    public void handleRegister() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal/management/system/RegisterScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            RegisterController nextController = loader.getController();
            nextController.setPrimaryStage(primaryStage);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Realizando Registro");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
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