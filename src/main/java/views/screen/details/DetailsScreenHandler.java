package views.screen.details;

import dao.media.MediaDAO;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;
import java.util.logging.Logger;

public class DetailsScreenHandler extends BaseScreenHandler {
    public static Logger LOGGER = Utils.getLogger(DetailsScreenHandler.class.getName());

    private Media media;
    @FXML
    protected Spinner<Integer> spinnerChangeNumber;

    @FXML
    protected Button addToCartBtn;

    MediaHandler mediaHandler;

    public DetailsScreenHandler(Stage stage, String screenPath, Media media) throws IOException {
        super(stage, screenPath, media);
        LOGGER.info("contructor");

    }

    @Override
    protected void setupData(Object dto) throws Exception {
        this.media = (Media) dto;
        LOGGER.info(this.media.getClass().getName() + " : " + this.media.getTitle());
        Media mediaDetails = new MediaDAO().getMediaById(this.media.getId());
        LOGGER.info(mediaDetails.getTitle());
        String mediaType = media.getType();
        LOGGER.info(mediaType);
        if (mediaType.equals("book")) {
            mediaHandler = new BookHandler(ViewsConfig.DETAILS_MEDIA_PATH, media);
        } else if (mediaType.equals("cd")) {
            mediaHandler = new CDHandler(ViewsConfig.DETAILS_MEDIA_PATH, media);
        } else if (mediaType.equals("dvd")) {
            mediaHandler = new BookHandler(ViewsConfig.DETAILS_MEDIA_PATH, media);
        } else {
            LOGGER.info("not Bool");
        }

    }


}
