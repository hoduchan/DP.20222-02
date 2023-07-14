package views.screen.popup;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;

public abstract class HandleFeedBackScreen extends BaseScreenHandler {
    @FXML
    Label message;
    protected HandleFeedBackScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath, null);
    }

    public static void success(String message) throws IOException{
    }

    public static void error(String message) throws IOException {
    }

}
