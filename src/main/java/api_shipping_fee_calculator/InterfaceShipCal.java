package api_shipping_fee_calculator;

import java.util.List;

public interface InterfaceShipCal {
    public int calculate(List orderMediaList, int distance);
}