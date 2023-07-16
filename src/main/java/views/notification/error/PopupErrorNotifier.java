package views.notification.error;
import java.io.IOException;
import java.util.logging.Logger;

import utils.Utils;
import views.screen.home.HomeScreenHandler;
import views.screen.popup.PopupScreen;


public class PopupErrorNotifier extends ErrorNotifier {
    public static Logger LOGGER = Utils.getLogger(PopupErrorNotifier.class.getName());

    public PopupErrorNotifier() {}

    @Override
    public void error(String message) throws IOException {
        LOGGER.info("POPUP");
        PopupScreen.error(message);
    }
}

