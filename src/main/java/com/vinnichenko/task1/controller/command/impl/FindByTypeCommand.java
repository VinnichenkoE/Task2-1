package com.vinnichenko.task1.controller.command.impl;

import com.vinnichenko.task1.controller.RequestParameter;
import com.vinnichenko.task1.controller.ResponseParameter;
import com.vinnichenko.task1.controller.command.Command;
import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.model.entity.Appliance;
import com.vinnichenko.task1.model.service.impl.ApplianceServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByTypeCommand implements Command {
    @Override
    public Map<String, Object> execute(Map<String, String> parameters) {
        ApplianceServiceImpl service = new ApplianceServiceImpl();
        String type = parameters.get(RequestParameter.TYPE);
        Map<String, Object> response = new HashMap<>();
        try {
            List<Appliance> applianceList = service.findByType(type);
            response.put(ResponseParameter.STATUS,
                    ResponseParameter.SUCCESS_STATUS);
            response.put(ResponseParameter.RESULT, applianceList);
        } catch (ServiceException e) {
            response.put(ResponseParameter.STATUS,
                    ResponseParameter.FAIL_STATUS);
            response.put(ResponseParameter.MESSAGE, e.getMessage());
        }
        return response;
    }
}
