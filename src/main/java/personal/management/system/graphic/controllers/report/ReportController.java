package personal.management.system.graphic.controllers.report;

import javafx.stage.Stage;

public class ReportController {

    private Stage primaryStage;
    private String loggedUser;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserData(String username){
        this.loggedUser = username;
    }
}
