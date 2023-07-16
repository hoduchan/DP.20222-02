package views.screen.payment;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;

public class ResultScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	private String result;
	private String message;

	public ResultScreenHandler(Stage stage, String screenPath, Map<String, String> response) throws IOException {
		super(stage, screenPath, response);
//		try {
//			setupData(response);
//			setupFunctionality();
//		} catch (IOException ex) {
//			LOGGER.info(ex.getMessage());
//			PopupScreen.error("Error when loading resources.");
//		} catch (Exception ex) {
//			LOGGER.info(ex.getMessage());
//			PopupScreen.error(ex.getMessage());
//		}
	}

	@Override
	protected void setupData(Object dto) throws Exception {
		Map<String, String> response = (Map<String, String>) dto;
		resultLabel.setText(response.get("RESULT"));
		messageLabel.setText(response.get("MESSAGE"));
	}

//	protected void setupFunctionality() throws Exception {
//		return;
//	}

	@FXML
	private Label pageTitle;

	@FXML
	private Label resultLabel;

	@FXML
	private Button okButton;
	
	@FXML
	private Label messageLabel;

	@FXML
	void confirmPayment(MouseEvent event) throws IOException {
		homeScreenHandler.show();
	}
}
