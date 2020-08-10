package com.vinnichenko.task1.model.service.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.exception.DaoException;
import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.model.dao.impl.ApplianceDaoImpl;
import com.vinnichenko.task1.model.entity.Appliance;
import com.vinnichenko.task1.model.service.ApplianceService;
import com.vinnichenko.task1.parser.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {
    @Override
    public List<Appliance> findByType(String type) throws ServiceException {
        if (type == null) {
            throw new ServiceException("incorrect value of type");
        }
        ApplianceDaoImpl applianceDao = new ApplianceDaoImpl();
        List<String> appliances;
        try {
            appliances = applianceDao.findByType(type);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
        StringParser stringParser = new StringParser();
        List<Appliance> applianceList = new ArrayList<>();
        ApplianceCreator applianceCreator = new ApplianceCreator();
        for (String stringAppliance : appliances) {
            Map<String, String> parameters = stringParser.stringToParameters(stringAppliance);
            Appliance appliance = applianceCreator.createAppliance(parameters);
            applianceList.add(appliance);
        }
        return applianceList;
    }

    @Override
    public List<Appliance> findByParameter(String parameter, String value) {
        return null;
    }
}
