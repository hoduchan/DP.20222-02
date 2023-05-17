package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

// DIP vì phụ thuộc vào lớp DistanceCalculator - 1 lớp cấp thấp, nên sử dụng giao diện DistanceCalculatorInterface 
public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }
    /*
    *  Vi phạm OCP vì khi thay đổi các tính phí
    * cũng như các tính khoảng cách sẽ phải sửa đổi
    */
    //stampling coupling biến order không sử dụng
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
