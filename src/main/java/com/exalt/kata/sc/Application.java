package com.exalt.kata.sc;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.exalt.kata.sc.exception.MalformedInputException;

public class Application {

    static int add(String numbers) throws MalformedInputException {
        var pattern = Pattern.compile("\\s+|(?:\\-?\\d+[,\\n])*\\-?\\d{1}");
        var matcher = pattern.matcher(numbers);
        if (!matcher.matches()) {
            throw new MalformedInputException("Malformed input numbers");
        }
        return Arrays.stream(numbers.split("[,\\n]"))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
