package org.example.string;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringUtil {
    private static StringUtil instance;

    @Getter
    @Setter
    private String separator;

    private StringUtil() {
        this.separator = ",";
    }

    public static StringUtil getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final StringUtil INSTANCE = new StringUtil();
    }

    public char extractCharacter(String input, int index) {
        return input.charAt(index);
    }

    public String[] split(String input) {
        return this.split(input, "", "", this.separator);
    }

    public String[] split(String input, String separator) {
        return this.split(input, "", "", separator);
    }

    public String[] split(String input, String prefix, String suffix) {
        return this.split(input, prefix, suffix, this.separator);
    }

    public String[] split(String input, String prefix, String suffix, String separator) {
        return this._split(input, prefix, suffix, separator);
    }

    private String[] _split(@NonNull String input, @NonNull String prefix, @NonNull String suffix, @NonNull String separator) {
        int startIndex = 0;
        int endIndex = input.length();

        if (prefix.equals(input.substring(0, prefix.length()))) {
            startIndex = prefix.length();
        }

        if (suffix.equals(input.substring(input.length() - suffix.length()))) {
            endIndex = input.length() - suffix.length();
        }

        return input.substring(startIndex, endIndex).split(separator);
    }
}
