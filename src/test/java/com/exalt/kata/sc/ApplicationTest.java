package com.exalt.kata.sc;

import com.exalt.kata.sc.exception.MalformedInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.exalt.kata.sc.Application.*;
import static org.assertj.core.api.Assertions.*;


class ApplicationTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
                 '  ',   0
                 '1,2',  3
                 '3,-3', 0
            """)
    void shouldAddNumbers(String numbers, int result) throws MalformedInputException {
        assertThat(add(numbers)).isEqualTo(result);
    }

    @Test
    void shouldThrowMalFormedException() {
        assertThatThrownBy(() -> add("1,2,-3")).isInstanceOf(MalformedInputException.class);
    }
}
