package views.screen.details;

import dao.media.BookDAO;
import entity.media.Media;
import utils.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public  class CDHandler extends MediaHandler{
    public static Logger LOGGER = Utils.getLogger(CDHandler.class.getName());

    public CDHandler(String screenPath, Media media) throws IOException {
        super(screenPath, media);
        try {
            media = new BookDAO().getMediaById(media.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
