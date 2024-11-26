package com.cyber_guardians.Cyber_Guardians.Util;

public class PasswordCrackingTimeCalculator {

    public static String calculateCrackingTime(String password) {
        int charsetSize = getCharsetSize(password);
        long combinations = (long) Math.pow(charsetSize, password.length());
        long guessesPerSecond = 1_000_000_000; // 초당 10억 시도 가정
        long seconds = combinations / guessesPerSecond;

        return formatTime(seconds);
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
        if (days < 30) return days + " days";
        long months = days / 30;
        long remainingDays = days % 30;
        if (months < 12) {
            if (remainingDays > 0) return months + " months and " + remainingDays + " days";
            return months + " months";
        }
        long years = months / 12;
        return years + " years";
    }
}
