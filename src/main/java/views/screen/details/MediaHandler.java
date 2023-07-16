package views.screen.details;

import entity.media.Media;
import views.screen.FXMLScreenHandler;

import java.io.IOException;

public abstract class MediaHandler extends FXMLScreenHandler {
    Media media;

    public MediaHandler(String screenPath, Media media) throws IOException {
        super(screenPath);
        this.media = media;
    }
}
