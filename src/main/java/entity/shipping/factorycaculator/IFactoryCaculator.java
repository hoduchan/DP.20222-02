package entity.shipping.factorycaculator;

import entity.shipping.caculator.IDistanceCalculator;

public interface IFactoryCaculator {
    IDistanceCalculator createDistanceCalculator();
}
