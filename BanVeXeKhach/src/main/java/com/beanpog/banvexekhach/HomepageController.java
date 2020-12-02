package com.beanpog.banvexekhach;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomepageController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
