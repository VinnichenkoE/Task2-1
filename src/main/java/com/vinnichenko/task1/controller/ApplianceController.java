package com.vinnichenko.task1.controller;

import com.vinnichenko.task1.controller.command.Command;
import com.vinnichenko.task1.controller.command.CommandProvider;

import java.util.Map;

public class ApplianceController {

    private static final ApplianceController INSTANCE = new ApplianceController();

    private ApplianceController() {
    }

    public static ApplianceController getInstance() {
        return INSTANCE;
    }

    public Map<String, Object> executeTask(Map<String, String> parameters) {
        String commandName = parameters
                .get(RequestParameter.COMMAND_NAME);
        CommandProvider provider = new CommandProvider();
        Command command = provider.getCommand(commandName);
        return command.execute(parameters);
    }
}
