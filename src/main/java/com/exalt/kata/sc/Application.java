package com.exalt.kata.sc;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.exalt.kata.sc.exception.MalformedInputException;

public class Application {

    static int add(String numbersString) throws MalformedInputException {
        var pattern = Pattern.compile("(\\s+)|(?:\\/\\/([^\\-1-9])\\n)?((?:\\-?\\d+[\\D\\-])*\\-?\\d{1})");
        var matcher = pattern.matcher(numbersString);
        if (!matcher.matches()) {
            throw new MalformedInputException("Malformed input numbers");
        }
        if (matcher.group(1) != null) { // empty string
            return 0;
        }
        var delimiter = matcher.group(2);
        var numbers = matcher.group(3);
        return Arrays.stream(numbers.split(delimiter == null ? "[,\\n]" : "\\" + delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
