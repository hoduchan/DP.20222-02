package api_shipping_fee_calculator;

import java.util.List;

public class ShippngFeeCaculator implements InterfaceShipCal {
    public ShippngFeeCaculator() {
    }

    public int calculate(List orderMediaList, int distance) {
        return (int) (distance * 1.2);
    }
}

