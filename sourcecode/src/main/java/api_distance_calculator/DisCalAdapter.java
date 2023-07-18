package api_distance_calculator;

import org.example.DistanceCalculator;

public class DisCalAdapter implements InterfaceDisCal {
    private DistanceCalculator disCal;

    public DisCalAdapter() {
        disCal = new DistanceCalculator();
    }
    public int calculate(String address, String province) {
        return disCal.calculateDistance(address, province);
    }
} 