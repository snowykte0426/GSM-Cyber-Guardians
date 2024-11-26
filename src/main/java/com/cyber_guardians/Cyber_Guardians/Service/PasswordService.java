package com.cyber_guardians.Cyber_Guardians.Service;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;
import com.cyber_guardians.Cyber_Guardians.Util.PasswordCrackingTimeCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public PasswordEvaluationResponse evaluatePassword(String password) {
        String crackingTime = PasswordCrackingTimeCalculator.calculateCrackingTime(password);
        String strength = determineStrengthByTime(crackingTime); // 시간을 기준으로 강도 계산

        List<String> recommendations = generateRecommendations(password);

        return new PasswordEvaluationResponse(crackingTime, strength, recommendations);
    }

    public String determineStrengthByTime(String crackingTime) {
        if (crackingTime.endsWith("seconds") || crackingTime.endsWith("hours")) {
            return "Weak";
        } else if (crackingTime.endsWith("minutes") || crackingTime.equals("days")) {
            return "Moderate";
        } else if (crackingTime.contains("months") && crackingTime.contains("days")) {
            return "Strong";
        } else if (crackingTime.endsWith("months")) {
            return "Strong";
        } else if (crackingTime.endsWith("years")) {
            return "Very Strong";
        }
        return "Unknown";
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
