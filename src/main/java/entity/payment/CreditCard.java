package entity.payment;

/**
 * @author
 */

// SOLID : Vi phạm OCP
// Lớp này chỉ chứa đói tượng Card,
// các lớp khác sử dụng trực tiếp
// đối tượng Card. Việc mở rộng sau
// này có thể vi phạm OCP

public class CreditCard {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
