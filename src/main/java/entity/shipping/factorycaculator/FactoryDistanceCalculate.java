package entity.shipping.factorycaculator;

import entity.shipping.caculator.DistanceCalculatorApi;
import entity.shipping.caculator.IDistanceCalculator;

public class FactoryDistanceCalculate implements IFactoryCaculator{
    @Override
    public IDistanceCalculator createDistanceCalculator() {
        return new DistanceCalculatorApi();
    }
}
