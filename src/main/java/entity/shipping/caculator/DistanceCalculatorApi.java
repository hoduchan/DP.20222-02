package entity.shipping.caculator;

import org.example.DistanceCalculator;

public class DistanceCalculatorApi implements IDistanceCalculator {
    private  DistanceCalculator distanceCalculator = new DistanceCalculator();

    public DistanceCalculatorApi(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public DistanceCalculatorApi() {
    }

    @Override
    public int calculateDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address,province);
    }
}
