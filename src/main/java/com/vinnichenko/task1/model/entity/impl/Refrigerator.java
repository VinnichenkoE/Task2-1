package com.vinnichenko.task1.model.entity.impl;

import com.vinnichenko.task1.model.entity.KitchenAppliance;

public class Refrigerator extends KitchenAppliance {

    private double freezerCapacity;
    private double overallCapacity;

    public Refrigerator(double powerConsumption, double weight, double height, double width, double freezerCapacity, double overallCapacity) {
        super(powerConsumption, weight, height, width);
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Refrigerator that = (Refrigerator) o;

        if (Double.compare(that.freezerCapacity, freezerCapacity) != 0)
            return false;
        return Double.compare(that.overallCapacity, overallCapacity) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(freezerCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(overallCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Refrigerator{");
        sb.append(super.toString());
        sb.append("freezerCapacity=").append(freezerCapacity);
        sb.append(", overallCapacity=").append(overallCapacity);
        sb.append('}');
        return sb.toString();
    }
}
