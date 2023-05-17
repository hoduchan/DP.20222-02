package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;
    
    public Invoice(){

    }
    //SOLID : vi phạm nguyên lý DIP  phương thức này có 
    //tham số là 1 class cụ thể Order nếu sau này xuất hiện loại đơn hàng khác thì ảnh hưởng đến mã nguồn
    public Invoice(Order order){
        this.order = order;
        this.amount = order.getTotal();
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){
        
    }
}
