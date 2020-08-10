package com.vinnichenko.task1.controller.command;

import java.util.Map;

public interface Command {

    Map<String, Object> execute(Map<String, String> parameters);
}
