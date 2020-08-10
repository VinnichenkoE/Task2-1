package com.vinnichenko.task1.model.entity;

public abstract class Electronics implements Appliance {
    private double batteryCapacity;
    private int displayInches;
    private int memoryRom;

    public Electronics(double batteryCapacity, int displayInches, int memoryRom) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electronics that = (Electronics) o;

        if (Double.compare(that.batteryCapacity, batteryCapacity) != 0)
            return false;
        if (displayInches != that.displayInches) return false;
        return memoryRom == that.memoryRom;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        result = 31 * result + memoryRom;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", displayInches=").append(displayInches);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(' ');
        return sb.toString();
    }
}
