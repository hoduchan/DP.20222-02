package entity.shipping;

import entity.order.Order;
import entity.shipping.caculator.IDistanceCalculator;
import entity.shipping.factorycaculator.IFactoryCaculator;
import org.example.DistanceCalculator;

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected IFactoryCaculator iFactoryCaculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, IFactoryCaculator iFactoryCaculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.iFactoryCaculator = iFactoryCaculator;
    }

    // khi thay doi thu vien thi phai sua code nen ta ap dung Factory Pattern o day de tranh OCP
    public int calculateShippingFee(Order order) {
        IDistanceCalculator idc = this.iFactoryCaculator.createDistanceCalculator();
        int distance = idc.calculateDistance(address, province);
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
