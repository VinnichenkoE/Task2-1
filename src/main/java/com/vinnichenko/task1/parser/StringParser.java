package com.vinnichenko.task1.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String REGEX_APPLIANCE_TYPE = "(\\p{LC}+)\\s[:]";
    private static final String TYPE = "type";
    private static final String REGEX_PARAMETER = "(\\p{LC}+[_]*\\p{LC}*)[=](\\d*\\p{LC}*)";

    public Map<String, String> stringToParameters(String stringAppliance) {
        Map<String, String> parameters = new HashMap<>();
        Pattern patternType = Pattern.compile(REGEX_APPLIANCE_TYPE);
        Matcher matcherType = patternType.matcher(stringAppliance);
        String type = null;
        if (matcherType.find()) {
            type = matcherType.group(1);
        }
        parameters.put(TYPE, type);
        Pattern patternParameter = Pattern.compile(REGEX_PARAMETER);
        Matcher matcherParameter = patternParameter.matcher(stringAppliance);
        while (matcherParameter.find()) {
            String parameter = matcherParameter.group(1);
            String value = matcherParameter.group(2);
            parameters.put(parameter, value);
        }
        return parameters;
    }
}
