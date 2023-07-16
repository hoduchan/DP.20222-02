package views.screen.home;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import common.exception.MediaNotAvailableException;
import common.interfaces.Observable;
import common.interfaces.Observer;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.FXMLScreenHandler;
import views.screen.ViewsConfig;
import views.screen.details.DetailsScreenHandler;
import views.screen.popup.PopupScreen;

public class MediaHandler extends FXMLScreenHandler implements Observable {

    @FXML
    protected ImageView mediaImage;

    @FXML
    protected Label mediaTitle;

    @FXML
    protected Label mediaPrice;

    @FXML
    protected Label mediaAvail;

    @FXML
    protected Spinner<Integer> spinnerChangeNumber;

    @FXML
    protected Button addToCartBtn;

    @FXML
    protected Button viewDetailsBtn;

    private static Logger LOGGER = Utils.getLogger(MediaHandler.class.getName());
    private Media media;
    private List<Observer> observerList;
    private MediaEvent mediaEvent;

    public MediaHandler(String screenPath, Media media) throws SQLException, IOException{
        super(screenPath);
        this.media = media;
//        LOGGER.info(media.getClass().getName());
        this.observerList = new ArrayList<>();
        addToCartBtn.setOnMouseClicked(event -> {
            mediaEvent = MediaEvent.ADD_TO_CART;
            notifyObservers();
        });
        viewDetailsBtn.setOnMouseClicked(event ->{
            mediaEvent = MediaEvent.VIEW_DETAILS;
            notifyObservers();
        });
        setMediaInfo();
    }

    Media getMedia(){
        return media;
    }
    int getRequestQuantity() {
        return spinnerChangeNumber.getValue();
    }

    private void setMediaInfo() throws SQLException {
        // set the cover image of media
        File file = new File(media.getImageURL());
        Image image = new Image(file.toURI().toString());
        mediaImage.setFitHeight(160);
        mediaImage.setFitWidth(152);
        mediaImage.setImage(image);

        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(ViewsConfig.getCurrencyFormat(media.getPrice()));
        mediaAvail.setText(Integer.toString(media.getQuantity()));
        spinnerChangeNumber.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1)
        );
        setImage(mediaImage, media.getImageURL());
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(this));
    }
    public MediaEvent getMediaEvent() {
        return mediaEvent;
    }
}
