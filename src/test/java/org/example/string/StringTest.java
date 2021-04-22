package org.example.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    private StringUtil stringUtil;

    @BeforeEach
    void setUp() {
        stringUtil = StringUtil.getInstance();
    }

    @Test
    @DisplayName("Test string split")
    void test1_1() {
        // Given
        String input = "1,2";   // String input = Arrays.stream(want).collect(Collectors.joining(separator));
        String separator = ",";
        String[] want = new String[]{"1", "2"};

        // When
//        String[] got = input.split(separator);
        String[] got = stringUtil.split(input, separator);

        // Then
        assertThat(got).containsExactly(want);
    }

    @Test
    @DisplayName("Test string split - only one")
    void test1_2() {
        // Given
        String input = "1";
        String separator = ",";
        String[] want = new String[]{"1"};

        // When
//        String[] got = input.split(separator);
        String[] got = stringUtil.split(input, separator);

        // Then
        assertThat(got).containsExactly(want);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Test string split - NullPointerException case")
    void test1_3(String separator) {
        // Given
        String input = "1,2";
//        String separator = ",";
        String[] want = new String[]{"1", "2"};

        // When
        // Then
        assertThatThrownBy(() -> {
            String[] got = stringUtil.split(input, separator);
        }).isInstanceOf(NullPointerException.class).hasMessage("separator is marked non-null but is null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("Test string split - Empty Or Blank separator")
    void test1_4(String separator) {
        // Given
        String inputValue = "1,2";
        String[] want = new String[]{"1", "2"};

        // When
        String[] got = stringUtil.split(inputValue, separator);

        // Then
        assertThat(got).hasSizeGreaterThan(0);
    }

    @Test
    @DisplayName("Test string split with prefix, suffix")
    void test2_1() {
        // Given
        String input = "(1,2)";
        String prefix = "(";
        String suffix = ")";
        String separator = ",";
        String[] want = new String[]{"1", "2"};

        // When
        String[] got = stringUtil.split(input, prefix, suffix, separator);

        // Then
        assertThat(got).containsExactly(want);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Test string split with prefix, suffix - NullPointerException from prefix case")
    void test2_2(String prefix) {
        // Given
        String input = "(1,2)";
//        String prefix = "null";
        String suffix = ")";
        String separator = ",";
        String[] want = new String[]{"1", "2"};

        // When
        // Then
        assertThatThrownBy(() -> {
            String[] got = stringUtil.split(input, prefix, suffix, separator);
        }).isInstanceOf(NullPointerException.class).hasMessage("prefix is marked non-null but is null");
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Test string split with prefix, suffix - NullPointerException from suffix case")
    void test2_3(String suffix) {
        // Given
        String input = "(1,2)";
        String prefix = "(";
//        String suffix = null;
        String separator = ",";
        String[] want = new String[]{"1", "2"};

        // When
        // Then
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
                    String[] got = stringUtil.split(input, prefix, suffix, separator);
                }
        ).withMessageMatching("suffix is marked non-null but is null");
    }

    @Test
    @DisplayName("Test extract character")
    void test3_1() {
        // Given
        String input = "abc";
        int index = 2;
        char want = input.charAt(index);

        // When
        char got = stringUtil.extractCharacter(input, index);

        // Then
        assertThat(got).isEqualTo(want);
    }

    @Test
    @DisplayName("Test extract character - StringIndexOutOfBoundsException case")
    void test3_2() {
        // Given
        String input = "abc";
        int index = 4;
//        char want = input.charAt(index);

        // When
        // Then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            char got = stringUtil.extractCharacter(input, index);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
