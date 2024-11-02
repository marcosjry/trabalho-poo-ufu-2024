package personal.management.system.graphic.controllers.register;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import personal.management.system.graphic.controllers.login.LoginController;
import personal.management.system.models.LerEscrever;
import personal.management.system.models.User;
import personal.management.system.services.ServicoUsuario;
import personal.management.system.services.impl.ServicoUsuarioImpl;

public class RegisterController extends LerEscrever {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private PasswordField confirmarSenhaField;

    private Stage primaryStage;
    private ServicoUsuario servicoUsuarioImpl = new ServicoUsuarioImpl();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handleUserRegister() throws Exception {

        String nome = nomeField.getText();
        String email = emailField.getText();
        String password = senhaField.getText();
        String confirmPassword = confirmarSenhaField.getText();

        try {
            if(validateInput(nome, email, password, confirmPassword)) {

                User novoUsuario = new User();

                novoUsuario.setNome(nome);
                novoUsuario.setEmail(email);
                novoUsuario.setSenha(password);
                servicoUsuarioImpl.cadastrarUsuario(novoUsuario);

                archiveLoad(servicoUsuarioImpl.getUsuarios());

                System.out.println(novoUsuario);
                showAlert(Alert.AlertType.CONFIRMATION, "Registro Realizado", "O Registro foi realizado com sucesso!");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal/management/system/LoginScreen.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Tela de Login");


                LoginController nextController = loader.getController();
                nextController.setPrimaryStage(primaryStage);

            } else {
                showAlert(Alert.AlertType.WARNING, "Campos Inválidos!", "Por favor, preencha todos os campos.");
            };
        } catch (Exception e) {
            throw new Exception(e);
        }

    }


    public Boolean validateInput(String nome, String email, String senha, String confirmarSenha) {
        return !nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && confirmarSenha.equals(senha);
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
