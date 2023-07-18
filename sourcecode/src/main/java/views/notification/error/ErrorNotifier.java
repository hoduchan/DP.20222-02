package views.notification.error;

import java.io.IOException;

public abstract class  ErrorNotifier {
    public abstract void error(String message) throws IOException;

}
