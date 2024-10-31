module personal.management.system.pms {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens personal.management.system.graphic.controllers.login to javafx.fxml;
    opens personal.management.system.graphic.controllers.home to javafx.fxml;
    opens personal.management.system.graphic.controllers.budget to javafx.fxml;
    opens personal.management.system.graphic.controllers.report to javafx.fxml;
    opens personal.management.system.graphic.controllers.schedule to javafx.fxml;
    opens personal.management.system.graphic.controllers.transaction to javafx.fxml;

    opens personal.management.system.models to javafx.base;

    exports personal.management.system.graphic.controllers.login;
    exports personal.management.system;
}