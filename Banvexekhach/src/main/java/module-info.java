module com.mycompany.banvexekhach {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.banvexekhach to javafx.fxml;
    exports com.mycompany.banvexekhach;
}
