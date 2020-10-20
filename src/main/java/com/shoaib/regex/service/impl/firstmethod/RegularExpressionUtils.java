package com.shoaib.regex.service.impl.firstmethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class RegularExpressionUtils {

       public static Matcher createMatcherWithTimeout(String stringToMatch, String regularExpression, int timeoutMillis) {
        Pattern pattern = Pattern.compile(regularExpression);
        return createMatcherWithTimeout(stringToMatch, pattern, timeoutMillis);
    }

    public static Matcher createMatcherWithTimeout(String stringToMatch, Pattern regularExpressionPattern, int timeoutMillis) {
        CharSequence charSequence = new TimeoutRegexCharSequence(stringToMatch, timeoutMillis, stringToMatch,
                regularExpressionPattern.pattern());
        return regularExpressionPattern.matcher(charSequence);
    }

    private static class TimeoutRegexCharSequence implements CharSequence {

        private final CharSequence inner;

        private final int timeoutMillis;

        private final long timeoutTime;

        private final String stringToMatch;

        private final String regularExpression;

        public TimeoutRegexCharSequence(CharSequence inner, int timeoutMillis, String stringToMatch, String regularExpression) {
            super();
            this.inner = inner;
            this.timeoutMillis = timeoutMillis;
            this.stringToMatch = stringToMatch;
            this.regularExpression = regularExpression;
            timeoutTime = System.currentTimeMillis() + timeoutMillis;
        }

        public char charAt(int index) {
            if (System.currentTimeMillis() > timeoutTime) {
                throw new RuntimeException("Timeout occurred after " + timeoutMillis + "ms while processing regular expression '"
                        + regularExpression + "' on input '" + stringToMatch + "'!");
            }
            return inner.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return null;
        }

        @Override
        public IntStream chars() {
            return null;
        }

        @Override
        public IntStream codePoints() {
            return null;
        }

        public int length() {
            return inner.length();
        }
    }
}