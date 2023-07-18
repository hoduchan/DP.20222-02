package entity.order;

public class OrderApproved implements OrderState{
    public void cancel() {
        System.out.println("Can not Cancel");
    }
}
