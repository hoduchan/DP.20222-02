package entity.shipping.factorycaculator;

import entity.shipping.caculator.AltDistanceCalculateApi;
import entity.shipping.caculator.IDistanceCalculator;

public class FactoryAltDistanceCalculate implements IFactoryCaculator {
    @Override
    public IDistanceCalculator createDistanceCalculator() {
        return new AltDistanceCalculateApi();
    }
}
