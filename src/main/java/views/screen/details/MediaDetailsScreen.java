package views.screen.details;

import entity.media.Media;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

import java.io.IOException;

public class MediaDetailsScreen extends BaseScreenHandler {
    private Media media;

    protected MediaDetailsScreen(Stage stage, String screenPath, Object dto) throws IOException {
        super(stage, screenPath, dto);
    }

    @Override
    protected void setupData(Object dto) throws Exception {
        super.setupData(dto);
    }
}
