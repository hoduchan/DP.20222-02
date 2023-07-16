package entity.shipping;

import entity.order.Order;
//import org.example.DistanceCalculator;
import api_distance_calculator.InterfaceDisCal;
import api_shipping_fee_calculator.InterfaceShipCal;
import java.util.List;

// DIP vì phụ thuộc vào lớp DistanceCalculator - 1 lớp cấp thấp, nên sử dụng giao diện DistanceCalculatorInterface
public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    //protected DistanceCalculator distanceCalculator;
    protected InterfaceDisCal disCal;
    protected InterfaceShipCal shipCal;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        //this.distanceCalculator = distanceCalculator;
    }

    public int calculateShippingFee(Order order) {
        int distance = disCal.calculate(address, province);
        List orderMediaList = order.getOrderMediaList();
        //return (int) (distance * 1.2);
        return shipCal.calculate(orderMediaList, distance);
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

    public void setDistanceCalculator(InterfaceDisCal calculator) {
        this.disCal = calculator;
    }

    public void setShippingFeeCalculator(InterfaceShipCal calculator) {
        this.shipCal = calculator;
    }
}
