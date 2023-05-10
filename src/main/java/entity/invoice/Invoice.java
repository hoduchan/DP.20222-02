package entity.invoice;

import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;
    
    public Invoice(){

    }

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
    // coincidental cohesion: saveInvoice() khong lien quan toi nghiep vu cua class
    //SOLID : vì vi phạm nguyên tắc SRP vì entity này chỉ cần tạo ra các đối tượng invoice mà ko nên có các phương thức như saveInvoice
    public void saveInvoice(){
        
    }
}
