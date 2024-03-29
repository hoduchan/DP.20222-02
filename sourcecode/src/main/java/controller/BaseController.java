package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 * 
 * Functional Cohesion vì các phương thức đều liên quan đến việc xử lý giỏ hàng
 */
/*
* LSP
* Các class kế thừa như Authentication không cần có  checkMediaInCart()  getListCartMedia()
* */
public class BaseController {
    private SessionInformation sessionInformation = SessionInformation.getInstance();
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */
    public CartItem checkMediaInCart(Media media){
        return sessionInformation.getCartInstance().checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        return sessionInformation.getCartInstance().getListMedia();
    }
}
