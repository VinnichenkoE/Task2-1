package com.vinnichenko.task1.controller.command;

import com.vinnichenko.task1.controller.command.impl.FindByParameterCommand;
import com.vinnichenko.task1.controller.command.impl.FindByTypeCommand;
import com.vinnichenko.task1.controller.command.impl.WrongCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.FIND_BY_TYPE, new FindByTypeCommand());
        repository.put(CommandName.FIND_BY_PARAMETER, new FindByParameterCommand());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    public Command getCommand(String commandName) {
        Command command;
        try {
            command = repository
                    .get(CommandName.valueOf(commandName.toUpperCase()));
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}