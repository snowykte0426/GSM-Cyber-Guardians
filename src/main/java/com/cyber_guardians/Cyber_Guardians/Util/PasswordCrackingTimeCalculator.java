package com.cyber_guardians.Cyber_Guardians.Util;

public class PasswordCrackingTimeCalculator {

    public static String calculateCrackingTime(String password) {
        int charsetSize = getCharsetSize(password);
        long combinations = (long) Math.pow(charsetSize, password.length());
        long guessesPerSecond = 1_000_000_000; // 초당 10억 시도 가정
        long seconds = combinations / guessesPerSecond;

        return formatTime(seconds);
    }

    public static String calculateStrength(String password) {
        int length = password.length();
        int charsetSize = getCharsetSize(password);

        if (length < 6 || charsetSize < 26) {
            return "Weak";
        } else if (length < 8 || charsetSize < 52) {
            return "Moderate";
        } else if (length >= 8 && charsetSize >= 52) {
            return "Strong";
        } else if (length >= 12 && charsetSize >= 95) {
            return "Very Strong";
        }
        return "Unknown";
    }

    private static int getCharsetSize(String password) {
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        int size = 0;
        if (hasLower) size += 26;
        if (hasUpper) size += 26;
        if (hasDigit) size += 10;
        if (hasSpecial) size += 33;

        return size;
    }

    private static String formatTime(long seconds) {
        if (seconds < 60) return seconds + " seconds";
        long minutes = seconds / 60;
        if (minutes < 60) return minutes + " minutes";
        long hours = minutes / 60;
        if (hours < 24) return hours + " hours";
        long days = hours / 24;
        if (days < 365) return days + " days";
        long years = days / 365;
        return years + " years";
    }
}
