package com.vinnichenko.task1.model.service;

import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.model.entity.Appliance;

import java.util.List;

public interface ApplianceService {

    List<Appliance> findByType(String type) throws ServiceException;

    List<Appliance> findByParameter(String parameter, String value);
}
