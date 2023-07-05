package entity.shipping;

import org.example.DistanceCalculator;

public class AdapterDistance implements CalcuDistanceStrategy {

    protected DistanceCalculator distanceCalculator;

    public AdapterDistance(){
        this.distanceCalculator=new DistanceCalculator();
    }

    @Override
    public int calculateDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address, province);
    }
}
