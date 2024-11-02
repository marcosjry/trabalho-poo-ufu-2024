package personal.management.system.graphic.controllers.budget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import personal.management.system.models.Orcamento;
import personal.management.system.models.Transacao;
import personal.management.system.services.ServicoOrcamento;
import personal.management.system.services.impl.ServicoOrcamentoImpl;

import java.net.URL;
import java.util.ResourceBundle;


public class BudgetController implements Initializable {

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField valorOrcamento;

    @FXML
    private TableView<Orcamento> tvOrcamentos;

    private ObservableList<String> categoriasOrcamento;

    private Stage primaryStage;
    private String loggedUser;

    private ObservableList<Orcamento> orcamentoObservableList;

    private ServicoOrcamento servicoOrcamento = new ServicoOrcamentoImpl();


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserData(String username){
        this.loggedUser = username;
    }

    public void handleCreateBudget() throws Exception {
        String categoria = txtCategoria.getText();
        float orcamento = Float.parseFloat(valorOrcamento.getText());

        Orcamento novoOrcamento = new Orcamento();
        novoOrcamento.setCategoria(categoria);
        novoOrcamento.setValorTotal(orcamento);

        servicoOrcamento.adicionarOrcamento(novoOrcamento);
        orcamentoObservableList.add(novoOrcamento);

        if (!categoriasOrcamento.contains(categoria)) {
            categoriasOrcamento.add(categoria);
        }
    }

    public void setCategoriasOrcamento(ObservableList<String> categoriasOrcamento) {
        this.categoriasOrcamento = categoriasOrcamento;
    }

    public void handleDeleteBudget(){}

    public void handleEditBudget(){}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orcamentoObservableList = FXCollections.observableArrayList();
        this.tvOrcamentos.setItems(orcamentoObservableList);
    }
}
