package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.payment.CreditCard;
import entity.payment.PaymentCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;
import utils.TimeUtil;

//CLEAN CLASS: Chứa phương thức validate
//SOLID: Vi phạm OCP vì khi thêm mới phương thức thanh toán Sẽ phải chỉnh sửa code ở đây để
//có thể chọn thêm phương thức
/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 * 
 *  Procedural cohesion vì payOrder cần dùng  getExpirationDate để lấy ngày hết hạn thẻ tại thời điểm thanh toán
 *  emptyCart -> không liên quan -> Coincidental cohesion
 */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private PaymentCard card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	public PaymentController(InterbankInterface interbankInterface) {
		this.interbank = interbankInterface;
	}

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount   - the amount to pay
	 * @param contents - the transaction contents
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */

	/*
	 * OCP
	 * nếu thêm phương thức thay toán mới ví dụ thẻ nội địa (domestic card)
	 *  không phải dùng CreditCard nữa phải sửa đổi lại code
	 */

	// Data Coupling: Truyen vao cac tham so va phuc vu luong thuc thi
	public Map<String, String> payOrder(int amount, String contents, PaymentCard paymentCard) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = paymentCard;
			this.interbank = new InterbankSubsystem();
			PaymentTransaction transaction = interbank.payOrder(paymentCard, amount, contents);
			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void emptyCart() {
		SessionInformation.getInstance().getCartInstance().emptyCart();
	}
}