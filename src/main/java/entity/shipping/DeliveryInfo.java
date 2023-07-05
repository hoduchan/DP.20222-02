package entity.shipping;

import entity.order.Order;
//import org.example.DistanceCalculator;

public class DeliveryInfo {

    private String name;
    private String phone;
    private String province;
    private String address;
    private String shippingInstructions;
    protected CalcuDistanceStrategy distanceCalculator;

    private CalculatorShipFreeStrategy calculatorShipFreeStrategy;

    public void setCalculatorShipFreeStrategy(CalculatorShipFreeStrategy calculatorShipFreeStrategy) {
        this.calculatorShipFreeStrategy = calculatorShipFreeStrategy;
    }

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions
            , CalcuDistanceStrategy distanceCalculator
    ) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        if (calculatorShipFreeStrategy == null) {
            this.calculatorShipFreeStrategy = new CalShippingFee();
        }
        return (int) (this.calculatorShipFreeStrategy.calculatorShippingFee(distance));
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setShippingInstructions(String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }
}
