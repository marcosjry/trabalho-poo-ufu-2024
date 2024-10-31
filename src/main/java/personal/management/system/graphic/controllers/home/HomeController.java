package personal.management.system.graphic.controllers.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import personal.management.system.graphic.controllers.budget.BudgetController;
import personal.management.system.graphic.controllers.report.ReportController;
import personal.management.system.graphic.controllers.schedule.ScheduleController;
import personal.management.system.graphic.controllers.transaction.TransactionController;

public class HomeController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab transactionTab;

    @FXML
    private Tab scheduleTab;

    @FXML
    private Tab budgetTab;

    @FXML
    private Tab reportTab;


    private Stage primaryStage;
    private String loggedUser;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setLoggedUser(String username){
        this.loggedUser = username;
    }

    @FXML
    public void initialize() {
        try {
            // Carregando e configurando o controlador da aba de transações
            FXMLLoader transactionLoader = new FXMLLoader(getClass().getResource("/personal/management/system/transactionScreen.fxml"));
            transactionTab.setContent(transactionLoader.load());
            TransactionController transactionController = transactionLoader.getController();
            transactionController.setPrimaryStage(primaryStage);
            transactionController.setUserData(loggedUser);

            // Carregando e configurando o controlador da aba de agendamentos
            FXMLLoader scheduleLoader = new FXMLLoader(getClass().getResource("/personal/management/system/ScheduleScreen.fxml"));
            scheduleTab.setContent(scheduleLoader.load());
            ScheduleController scheduleController = scheduleLoader.getController();
            scheduleController.setPrimaryStage(primaryStage);
            scheduleController.setUserData(loggedUser);

            // Carregando e configurando o controlador da aba de orçamentos
            FXMLLoader budgetLoader = new FXMLLoader(getClass().getResource("/personal/management/system/BudgetScreen.fxml"));
            budgetTab.setContent(budgetLoader.load());
            BudgetController budgetController = budgetLoader.getController();
            budgetController.setPrimaryStage(primaryStage);
            budgetController.setUserData(loggedUser);

            // Carregando e configurando o controlador da aba de gráficos
            FXMLLoader reportLoader = new FXMLLoader(getClass().getResource("/personal/management/system/ReportScreen.fxml"));
            reportTab.setContent(reportLoader.load());
            ReportController reportController = reportLoader.getController();
            reportController.setPrimaryStage(primaryStage);
            reportController.setUserData(loggedUser);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
