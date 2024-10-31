package personal.management.system.graphic.controllers.transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import personal.management.system.models.Transacao;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    @FXML
    private ComboBox<String> tipoComboBox;
    @FXML
    private TextField valorTransacao;
    @FXML
    private DatePicker dataTransacao;
    @FXML
    private TextField descricaoTransacao;
    @FXML
    private TableView<Transacao> tabelaTransacoes;

    private ObservableList<Transacao> listaTransacoes;

    private Stage primaryStage;
    private String loggedUser;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserData(String username){
        this.loggedUser = username;
    }

    public void handleAddTransaction(ActionEvent event) {
        // Criar um novo objeto Transacao
        Transacao novaTransacao = new Transacao();

        LocalDate data = dataTransacao.getValue();
        String descricao = descricaoTransacao.getText();
        Float valor = Float.parseFloat(valorTransacao.getText());
        String tipo = tipoComboBox.getValue();
        System.out.println("Tipo: "+ tipo);
        System.out.println("Valor: "+ valor);
        System.out.println("Data: "+ data);
        System.out.println("Descrição: "+ descricao);
        if(verifyInput(descricao, valor, tipo)) {
            novaTransacao.setTipo(tipo);
            novaTransacao.setDescricao(descricao);
            novaTransacao.setValor(valor);
            novaTransacao.setData(data);
            listaTransacoes.add(novaTransacao);
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro ao adicionar Transação", "Ocorreu um erro ao registrar Transação, tente novamente.");
        }
    }

    public boolean verifyInput(String descricao, Float valor, String tipo) {
        if(tipo == null) return false;
        return !descricao.isEmpty() && valor > 0 && !tipo.isEmpty();
    }

    public void handleEditTransaction(){}

    public void handleDeleteTransaction(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaTransacoes = FXCollections.observableArrayList();
        tabelaTransacoes.setItems(listaTransacoes);

        // tipos de transação
        tipoComboBox.getItems().addAll("Receita", "Despesa");
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
