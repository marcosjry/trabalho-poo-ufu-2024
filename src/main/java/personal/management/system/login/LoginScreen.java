package personal.management.system.login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Label userLabel = new Label("Usuário:");
        grid.add(userLabel, 0, 0);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 0);

        Label pwLabel = new Label("Senha:");
        grid.add(pwLabel, 0, 1);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 1);


        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 2);


        loginButton.setOnAction(e -> {
            String username = userTextField.getText();
            String password = pwBox.getText();


            if (username.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campos vazios", "Por favor, preencha todos os campos.");
                return;
            }


            if (username.equals("admin") && password.equals("1234")) {
                showMainScreen(primaryStage);
            } else {
                showAlert(Alert.AlertType.ERROR, "Erro de Login", "Nome de usuário ou senha incorretos.");
            }
        });

        Scene scene = new Scene(grid, 700, 400);
        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);

        //Carrega o CSS
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

        primaryStage.show();
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showMainScreen(Stage primaryStage) {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        Label welcomeLabel = new Label("Bem-vindo à Tela Principal!");
        mainGrid.add(welcomeLabel, 0, 0);

        Scene mainScene = new Scene(mainGrid, 700, 400);
        //Troca a tela
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Tela Principal");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
