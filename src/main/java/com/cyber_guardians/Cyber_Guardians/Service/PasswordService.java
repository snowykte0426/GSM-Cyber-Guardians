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
        if (crackingTime.endsWith("초") || crackingTime.endsWith("분")) {
            return "Weak";
        } else if (crackingTime.endsWith("시간") || crackingTime.equals("일")) {
            return "Moderate";
        } else if (crackingTime.endsWith("달")) {
            return "Strong";
        } else if (crackingTime.endsWith("년")) {
            return "Very Strong";
        }
        return "Unknown";
    }


    private List<String> generateRecommendations(String password) {
        List<String> recommendations = new ArrayList<>();

        if (password.length() < 8) recommendations.add("패스워드의 길이가 너무 짧습니다!");
        if (!password.matches(".*[A-Z].*")) recommendations.add("대문자를 추가하세요!");
        if (!password.matches(".*[a-z].*")) recommendations.add("소문자를 추가하세요!");
        if (!password.matches(".*[0-9].*")) recommendations.add("숫자를 추가하세요!");
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) recommendations.add("특수문자를 추가하세요!");

        return recommendations;
    }
}
