module com.beanpog.banvexekhach {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires mysql.connector.java;
    requires java.sql;

    opens com.beanpog.banvexekhach to javafx.fxml;
    exports com.beanpog.banvexekhach;
    
}
