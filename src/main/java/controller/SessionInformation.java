package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    // content coupling vì có sử dụng trực tiếp trong class AuthenticationController
    public static User mainUser;
    /*
     content coupling vì có sử dụng trực tiếp trong nhiều class khác như BaseController,
      PaymentController, Order, HomeScreenHandler ..
    */
    public static Cart cartInstance = new Cart();
    // content coupling vì có sử dụng trực tiếp trong class AuthenticationController
    public static LocalDateTime expiredTime;

}
