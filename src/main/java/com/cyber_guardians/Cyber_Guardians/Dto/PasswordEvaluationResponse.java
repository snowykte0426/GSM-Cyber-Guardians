package com.cyber_guardians.Cyber_Guardians.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PasswordEvaluationResponse {
    private String strength;
    private String crackingTime; // 남김
    private List<String> recommendations;

    public PasswordEvaluationResponse(String strength, String crackingTime, List<String> recommendations) {
        this.strength = strength;
        this.crackingTime = crackingTime;
        this.recommendations = recommendations;
    }

}
