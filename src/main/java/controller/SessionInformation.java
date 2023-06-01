package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
//Singleton: SessionInformation chi nen duoc tao mot the hien trong qua trinh chay,
// vi no khong thay doi trong mot phien lam viec
public class SessionInformation {
//    public static User mainUser;
//    public static Cart cartInstance = new Cart();
//    public static LocalDateTime expiredTime;
    private User mainUser;
    private Cart cartInstance = new Cart();
    private LocalDateTime expiredTime;

    private static SessionInformation instance;

    public static SessionInformation getInstance(){
        if(instance == null){
            instance = new SessionInformation();

        }
        return instance;
    }

    private SessionInformation(){
        instance = getInstance();
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public Cart getCartInstance() {
        return cartInstance;
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
