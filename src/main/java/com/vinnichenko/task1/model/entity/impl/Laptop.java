package com.vinnichenko.task1.model.entity.impl;

import com.vinnichenko.task1.model.entity.Electronics;

public class Laptop extends Electronics {

    private String OS;
    private double systemMemory;
    private double cpu;

    public Laptop(double batteryCapacity, int displayInches, int memoryRom, String OS, double systemMemory, double cpu) {
        super(batteryCapacity, displayInches, memoryRom);
        this.OS = OS;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.systemMemory, systemMemory) != 0)
            return false;
        if (Double.compare(laptop.cpu, cpu) != 0) return false;
        return OS != null ? OS.equals(laptop.OS) : laptop.OS == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (OS != null ? OS.hashCode() : 0);
        temp = Double.doubleToLongBits(systemMemory);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append(super.toString());
        sb.append("OS='").append(OS).append('\'');
        sb.append(", systemMemory=").append(systemMemory);
        sb.append(", cpu=").append(cpu);
        sb.append('}');
        return sb.toString();
    }
}
