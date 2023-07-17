package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 *
 *
 */
public class ViewCartController extends BaseController{
    private SessionInformation sessionInformation = SessionInformation.getInstance();
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        sessionInformation.getCartInstance().checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        int subtotal = sessionInformation.getCartInstance().calSubtotal();
        return subtotal;
    }

}
