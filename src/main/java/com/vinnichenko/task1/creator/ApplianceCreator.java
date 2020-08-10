package com.vinnichenko.task1.creator;

import com.vinnichenko.task1.model.entity.Appliance;
import com.vinnichenko.task1.model.entity.impl.Oven;

import java.util.Map;

public class ApplianceCreator {

    public Appliance createAppliance(Map<String, String> parameters) {
        String type = parameters.get("type");
        Appliance appliance = null;
        switch (type) {
            case "Oven":
                String stringPowerConsumption = parameters.get("POWER_CONSUMPTION");
                double powerConsumption = Double.parseDouble(stringPowerConsumption);
                String stringWeight = parameters.get("WEIGHT");
                double weight = Double.parseDouble(stringWeight);
                String stringCapacity = parameters.get("CAPACITY");
                double capacity = Double.parseDouble(stringCapacity);
                String stringDepth = parameters.get("DEPTH");
                double depth = Double.parseDouble(stringDepth);
                String stringHeight = parameters.get("HEIGHT");
                double height = Double.parseDouble(stringHeight);
                String stringWidth = parameters.get("WIDTH");
                double width = Double.parseDouble(stringWidth);
                appliance = new Oven(powerConsumption, weight, capacity, depth, height, width);
        }
        return appliance;
    }
}
