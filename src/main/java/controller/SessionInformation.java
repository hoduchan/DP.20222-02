package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    // common coupling vì có sử dụng trực tiếp trong class AuthenticationController
    private User mainUser;
    /*
     common coupling vì có sử dụng trực tiếp trong nhiều class khác như BaseController,
      PaymentController, Order, HomeScreenHandler ..
    */
    private Cart cartInstance = Cart.getInstance();
    // common coupling vì có sử dụng trực tiếp trong class AuthenticationController
    private LocalDateTime expiredTime;


    private static  SessionInformation instance;

    public static synchronized SessionInformation  getInstance(){
        if(instance == null){
            instance = new SessionInformation();

        }
        return instance;
    }

    private SessionInformation(){
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public Cart getCartInstance() {
        return Cart.getInstance();
    }

    public void setCartInstance(Cart cartInstance) {
        this.cartInstance = cartInstance;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

}
