package com.cyber_guardians.Cyber_Guardians.Dto;

import java.util.List;

public class PasswordEvaluationResponse {
    private int score;
    private String strength;
    private List<String> recommendations;

    public PasswordEvaluationResponse(int score, String strength, List<String> recommendations) {
        this.score = score;
        this.strength = strength;
        this.recommendations = recommendations;
    }

    public int getScore() {
        return score;
    }

    public String getStrength() {
        return strength;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }
}

