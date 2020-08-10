package com.vinnichenko.task1;

import com.vinnichenko.task1.controller.ApplianceController;
import com.vinnichenko.task1.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

import static com.vinnichenko.task1.controller.RequestParameter.*;

public class Main {
    public static void main(String[] args) throws ServiceException {
        ApplianceController controller = ApplianceController.getInstance();
        Map<String, String> request = new HashMap<>();
        request.put(TYPE, "Oven");
        request.put(COMMAND_NAME, "find_by_type");
        Map<String, Object> response = controller.executeTask(request);
        System.out.println(response);
    }
}
