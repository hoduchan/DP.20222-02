package views.screen.details;

import dao.media.BookDAO;
import entity.media.Media;
import utils.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public  class BookHandler extends MediaDetailsHandler {
    public static Logger LOGGER = Utils.getLogger(BookHandler.class.getName());

    public BookHandler(String screenPath, Media media) throws IOException {
        super(screenPath, media);
        try {
            LOGGER.info(media.getClass().getName());
            media = new BookDAO().getMediaById(media.getId());
            LOGGER.info(media.getClass().getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
