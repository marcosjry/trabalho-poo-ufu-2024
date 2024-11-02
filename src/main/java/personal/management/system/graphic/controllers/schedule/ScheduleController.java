package personal.management.system.graphic.controllers.schedule;

import javafx.stage.Stage;

public class ScheduleController {

    private Stage primaryStage;
    private String loggedUser;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUserData(String username){
        this.loggedUser = username;
    }

    public void handleAddSchedule(){}

    public void handleDeleteSchedule(){}

    public void handlePaySchedule(){}

    public void handleEditSchedule(){}

}
