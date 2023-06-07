package entity.shipping.caculator;

import org.example.AlternativeDistanceCalculator;
public class AltDistanceCalculateApi implements IDistanceCalculator{
    private AlternativeDistanceCalculator alternativeDistanceCalculator;

    public AltDistanceCalculateApi() {
    }


    @Override
    public int calculateDistance(String address, String province) {
//        alternativeDistanceCalculator.s
        return alternativeDistanceCalculator.calculateDistance(address);
    }


}
