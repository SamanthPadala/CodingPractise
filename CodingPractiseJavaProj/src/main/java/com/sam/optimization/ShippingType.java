package com.sam.optimization;

public enum ShippingType {
    GROUND {
        @Override
        public double getShippingCost(double weight) {
            return weight * 5.0;
        }
    },
    EXPRESS {
        @Override
        public double getShippingCost(double weight) {
            return weight * 10.0;
        }
    },
    PRIORITY {
        @Override
        public double getShippingCost(double weight) {
            return weight * 15.0;
        }
    };

    public abstract double getShippingCost(double weight);
}
