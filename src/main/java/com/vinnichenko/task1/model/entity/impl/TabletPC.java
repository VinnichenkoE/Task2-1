package com.vinnichenko.task1.model.entity.impl;

import com.vinnichenko.task1.model.entity.Electronics;

public class TabletPC extends Electronics {

    private double flashMemoryCapacity;
    private String color;

    public TabletPC(double batteryCapacity, int displayInches, int memoryRom, double flashMemoryCapacity, String color) {
        super(batteryCapacity, displayInches, memoryRom);
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) != 0)
            return false;
        return color != null ? color.equals(tabletPC.color) : tabletPC.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(flashMemoryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TabletPC{");
        sb.append(super.toString());
        sb.append("flashMemoryCapacity=").append(flashMemoryCapacity);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
