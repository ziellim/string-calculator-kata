package com.exalt.kata.sc;

import java.util.regex.Pattern;

import com.exalt.kata.sc.exception.MalformedInputException;

public class Application {

    static int add(String numbers) throws MalformedInputException {
        var pattern = Pattern.compile("(\\s+)|(\\-?\\d+),(\\-?\\d+)");
        var matcher = pattern.matcher(numbers);
        if (!matcher.matches()) {
            throw new MalformedInputException("Malformed input numbers");
        }
        return parseInt(matcher.group(2)) + parseInt(matcher.group(3));
    }

    private static int parseInt(String group) {
        return group == null ? 0 : Integer.parseInt(group);
    }
}
