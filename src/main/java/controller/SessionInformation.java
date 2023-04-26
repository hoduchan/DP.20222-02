package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    // common coupling vì có sử dụng trực tiếp trong class AuthenticationController
    public static User mainUser;
    /*
     common coupling vì có sử dụng trực tiếp trong nhiều class khác như BaseController,
      PaymentController, Order, HomeScreenHandler ..
    */
    public static Cart cartInstance = new Cart();
    // common coupling vì có sử dụng trực tiếp trong class AuthenticationController
    public static LocalDateTime expiredTime;

}
