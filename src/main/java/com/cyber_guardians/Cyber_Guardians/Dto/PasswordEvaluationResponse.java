package com.cyber_guardians.Cyber_Guardians.Dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PasswordEvaluationResponse {
    private String crackingTime; // 남김
    private List<String> recommendations;

    public PasswordEvaluationResponse(String crackingTime, List<String> recommendations) {
        this.crackingTime = crackingTime;
        this.recommendations = recommendations;
    }

    // Getter & Setter
}
