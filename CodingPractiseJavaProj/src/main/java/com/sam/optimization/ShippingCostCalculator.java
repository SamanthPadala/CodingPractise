package com.sam.optimization;

import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {

    public double calculateShippingCost(ShippingType shippingType, double weight) {
        return shippingType.getShippingCost(weight);
    }

    public static Map<String, Double> shippingMap = new HashMap<>();
    static{
        shippingMap.put("GROUND", 5.0);
        shippingMap.put("EXPRESS", 10.0);
        shippingMap.put("PRIORITY", 15.0);
    }
    public double calculateShippingCostWithStream(String shippingType, double weight) {
        return shippingMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(shippingType))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0.0) * weight;
    }
}
