package com.sam.optimization;

public class AvoidIfElse {

    public static void main(String args[]) {
        ShippingCostCalculator scc = new ShippingCostCalculator();
        System.out.println("Shipping cost for STANDARD: " + scc.calculateShippingCost(ShippingType.EXPRESS, 10));
        System.out.println("Shipping cost for EXPRESS: " + scc.calculateShippingCost(ShippingType.GROUND, 10));
        System.out.println("Shipping cost for SAME_DAY: " + scc.calculateShippingCost(ShippingType.PRIORITY, 10));


        System.out.println("Shipping cost for STANDARD: " + scc.calculateShippingCostWithStream("EXPRESS", 10));
        System.out.println("Shipping cost for EXPRESS: " + scc.calculateShippingCostWithStream("GROUND", 10));
        System.out.println("Shipping cost for SAME_DAY: " + scc.calculateShippingCostWithStream("PRIORITY", 10));








    }

    /**
     * Replace below if-else with ENUM
     *
     * public class ShippingCostCalculator {
     *     public double calculateShippingCost(String shippingType, double weight) {
     *         if (shippingType.equals("STANDARD")) {
     *             return weight * 5.0;
     *         } else if (shippingType.equals("EXPRESS")) {
     *             return weight * 10.0;
     *         } else if (shippingType.equals("SAME_DAY")) {
     *             return weight * 20.0;
     *         } else if (shippingType.equals("INTERNATIONAL")) {
     *             return weight * 50.0;
     *         } else if (shippingType.equals("OVERNIGHT")) {
     *             return weight * 30.0;
     *         }
     *         return 0;
     *     }
     * }
     */


}
