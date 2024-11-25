package com.cyber_guardians.Cyber_Guardians.Service;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;
import com.cyber_guardians.Cyber_Guardians.Util

import java.util.ArrayList;
import java.util.List;

public class PasswordService {

    public PasswordEvaluationResponse evaluatePassword(String password) {
        String crackingTime = PasswordCrackingTimeCalculator.calculateCrackingTime(password);

        List<String> recommendations = generateRecommendations(password);

        return new PasswordEvaluationResponse(crackingTime, recommendations);
    }

    private List<String> generateRecommendations(String password) {
        List<String> recommendations = new ArrayList<>();

        if (password.length() < 8) recommendations.add("Use a longer password");
        if (!password.matches(".*[A-Z].*")) recommendations.add("Add uppercase letters");
        if (!password.matches(".*[a-z].*")) recommendations.add("Add lowercase letters");
        if (!password.matches(".*[0-9].*")) recommendations.add("Add numbers");
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) recommendations.add("Add special characters");

        return recommendations;
    }
}
