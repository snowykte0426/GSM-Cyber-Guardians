package com.cyber_guardians.Cyber_Guardians.Service;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;

import java.util.ArrayList;
import java.util.List;

public class PasswordEvaluator {

    public PasswordEvaluationResponse evaluate(String password) {
        int score = calculateScore(password);
        String strength = determineStrength(score);

        // 추천사항 추가
        List<String> recommendations = generateRecommendations(password);

        return new PasswordEvaluationResponse(score, strength, recommendations);
    }

    private int calculateScore(String password) {
        int score = 0;

        // 길이에 따른 점수
        if (password.length() >= 8) score += 20;
        if (password.length() >= 12) score += 30;

        // 문자 조합 점수
        if (password.matches(".*[A-Z].*")) score += 20;
        if (password.matches(".*[a-z].*")) score += 20;
        if (password.matches(".*[0-9].*")) score += 20;
        if (password.matches(".*[!@#$%^&*()].*")) score += 20;

        // 기타 조건
        if (password.length() > 16) score += 10;

        return Math.min(score, 100);
    }

    private String determineStrength(int score) {
        if (score >= 80) return "strong";
        if (score >= 50) return "medium";
        return "weak";
    }

    private List<String> generateRecommendations(String password) {
        List<String> recommendations = new ArrayList<>();

        if (password.length() < 8) recommendations.add("Use a longer password");
        if (!password.matches(".*[A-Z].*")) recommendations.add("Add uppercase letters");
        if (!password.matches(".*[a-z].*")) recommendations.add("Add lowercase letters");
        if (!password.matches(".*[0-9].*")) recommendations.add("Add numbers");
        if (!password.matches(".*[!@#$%^&*()].*")) recommendations.add("Add special characters");

        return recommendations;
    }
}

