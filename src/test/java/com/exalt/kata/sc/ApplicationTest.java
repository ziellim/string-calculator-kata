package com.exalt.kata.sc;

import com.exalt.kata.sc.exception.MalformedInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.exalt.kata.sc.Application.*;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
                 '  ',          0
                 '1,2',         3
                 '3,-3',        0
                 '-1',          -1
                 '1,2,3',       6
                 '1,2,3,4',     10
                 '1,-2,3,4',    6
            """)
    void shouldAddNumbers(String numbers, int result) throws MalformedInputException {
        assertThat(add(numbers)).isEqualTo(result);
    }

    @Test
    void shouldAddNumberWithLines() throws MalformedInputException {
        assertThat(add("1,-2\n3,4")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,", ",1,2" })
    void shouldThrowMalFormedException(String numbers) {
        assertThatThrownBy(() -> add(numbers)).isInstanceOf(MalformedInputException.class);
    }

    @Test
    void shouldThrowMalFormedExceptionWithLines() {
        assertThatThrownBy(() -> add("1,\n")).isInstanceOf(MalformedInputException.class);
    }
}
