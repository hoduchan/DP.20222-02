package views.notification.error;

import utils.Utils;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.logging.Logger;


public class AlertErrorNotifier extends ErrorNotifier {
    public static Logger LOGGER = Utils.getLogger(AlertErrorNotifier.class.getName());

    public AlertErrorNotifier() {}

    @Override
    public void error(String message) throws IOException {
        LOGGER.info("ALRERT");
        PopupScreen.error( message);
    }
}

