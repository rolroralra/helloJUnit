package org.example.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(){{
            add(1);
            add(1);
            add(2);
            add(3);
        }};
    }

    @Test
    @DisplayName("Test set size")
    void test1() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ", input=" + ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @ValueSource(ints = {1, 2, 3})
    void test2(int input) {
        assertThat(numbers.contains(input)).isTrue();
        assertThat(numbers).containsAnyOf(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':', nullValues = {"null"})
    void test3(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
