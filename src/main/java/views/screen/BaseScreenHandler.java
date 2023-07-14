package views.screen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import controller.AuthenticationController;
import controller.BaseController;
import controller.PaymentController;
import entity.invoice.Invoice;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.home.HomeScreenHandler;
import views.screen.popup.HandleFeedBackScreen;
import views.screen.popup.PopupScreen;

public abstract class BaseScreenHandler extends FXMLScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(BaseScreenHandler.class.getName());


	private Scene scene;
	private BaseScreenHandler prev;
	protected final Stage stage;
	protected HomeScreenHandler homeScreenHandler;
	protected Hashtable<String, String> messages;
	private BaseController bController;

	private HandleFeedBackScreen handleFeedBackScreen;

	protected BaseScreenHandler(Stage stage, String screenPath,Object dto) throws IOException {
		super(screenPath);
		this.stage = stage;
		try {
			setupData(dto);
			setupFunctionality();
		} catch (IOException ex) {
			handleIOException(ex);
		} catch (Exception ex) {
			handlexception(ex);
		}
	}

	private void handlexception(Exception ex) throws IOException {
		LOGGER.info(ex.getMessage());
		if(this.handleFeedBackScreen == null){
			handleFeedBackScreen = new PopupScreen(stage);
		}
		this.handleFeedBackScreen.error("Error when loading resources.");
	}

	protected void handleIOException(IOException ex) throws IOException{
		LOGGER.info(ex.getMessage());
		if(this.handleFeedBackScreen == null){
			handleFeedBackScreen = new PopupScreen(stage);
		}
		this.handleFeedBackScreen.error("Error when loading resources.");
	}

	protected  void  setupData(Object dto) throws Exception {
	}

	protected void setupFunctionality() throws Exception {
	}

	public void setPreviousScreen(BaseScreenHandler prev) {
		this.prev = prev;
	}

	public BaseScreenHandler getPreviousScreen() {
		return this.prev;
	}

	public void show() {
		if (this.scene == null) {
			this.scene = new Scene(this.content);
		}
		this.stage.setScene(this.scene);
		this.stage.show();
	}

	public void setScreenTitle(String string) {
		this.stage.setTitle(string);
	}

	public void setBController(BaseController bController){
		this.bController = bController;
	}

	public BaseController getBController(){
		return this.bController;
	}

	public void forward(Hashtable messages) {
		this.messages = messages;
	}

	public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
		this.homeScreenHandler = HomeScreenHandler;
	}

	public void setHandleFeedBackScreen(HandleFeedBackScreen handleFeedBackScreen) {
		this.handleFeedBackScreen = handleFeedBackScreen;
	}
}
