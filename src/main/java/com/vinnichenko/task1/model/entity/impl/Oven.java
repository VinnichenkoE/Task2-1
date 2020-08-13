package com.vinnichenko.task1.model.entity.impl;

import com.vinnichenko.task1.model.entity.KitchenAppliance;

public class Oven extends KitchenAppliance {

    private double capacity;
    private double depth;

    public Oven(double powerConsumption, double weight, double capacity,
                double depth, double height, double width) {
        super(powerConsumption, weight, height, width);
        this.capacity = capacity;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Oven oven = (Oven) o;
        if (Double.compare(oven.capacity, capacity) != 0) {
            return false;
        }
        return Double.compare(oven.depth, depth) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oven{");
        sb.append(super.toString());
        sb.append("capacity=").append(capacity);
        sb.append(", depth=").append(depth);
        sb.append('}');
        return sb.toString();
    }
}
