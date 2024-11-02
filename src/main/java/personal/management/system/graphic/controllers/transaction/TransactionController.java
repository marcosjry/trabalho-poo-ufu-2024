package personal.management.system.graphic.controllers.transaction;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import personal.management.system.models.Transacao;
import personal.management.system.services.ServicoOrcamento;
import personal.management.system.services.ServicoTransacao;
import personal.management.system.services.ServicoUsuario;
import personal.management.system.services.impl.ServicoOrcamentoImpl;
import personal.management.system.services.impl.ServicoTransacaoImpl;
import personal.management.system.services.impl.ServicoUsuarioImpl;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Set;

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
    private ComboBox<String> categoriaTransacao;

    @FXML
    private TableView<Transacao> tabelaTransacoes;

    private ObservableList<Transacao> observableTransacoes;

    private ObservableList<String> categoriasOrcamento;

    private ServicoTransacao servicoTransacao = new ServicoTransacaoImpl();
    private ServicoOrcamento orcamento = new ServicoOrcamentoImpl();

    private Stage primaryStage;
    private String loggedUser;

    public void setCategoriasOrcamento(ObservableList<String> categoriasOrcamento) {
        this.categoriasOrcamento = categoriasOrcamento;

        categoriasOrcamento.addListener((ListChangeListener<String>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    categoriaTransacao.setItems(categoriasOrcamento);
                }
            }
        });
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserData(String username){
        this.loggedUser = username;
    }

    public void handleAddTransaction(ActionEvent event) {


        LocalDate data = dataTransacao.getValue();
        String descricao = descricaoTransacao.getText();
        String valor = valorTransacao.getText();
        String tipo = tipoComboBox.getValue();
        String categoria = categoriaTransacao.getValue();

        System.out.println("Tipo: "+ tipo);
        System.out.println("Valor: "+ valor);
        System.out.println("Data: "+ data);
        System.out.println("Descrição: "+ descricao);
        System.out.println("Categoria: "+ categoria);

        if(servicoTransacao.verifyInput(descricao, valor, tipo, categoria)) {
            float novoValor = Float.parseFloat(valor);
            observableTransacoes.add(servicoTransacao.adicionarTransacao(descricao, novoValor, tipo, categoria, data));
        } else {
            showAlert(Alert.AlertType.ERROR, "Erro ao adicionar Transação", "Ocorreu um erro ao registrar Transação, tente novamente.");
        }
    }



    public void handleEditTransaction(){}

    public void handleDeleteTransaction(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableTransacoes = FXCollections.observableArrayList();
        tabelaTransacoes.setItems(observableTransacoes);

        categoriaTransacao.setItems(categoriasOrcamento);

        //Set<String> categorias = servicoUsuario.getLoggedUser().getOrcamentos();


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
