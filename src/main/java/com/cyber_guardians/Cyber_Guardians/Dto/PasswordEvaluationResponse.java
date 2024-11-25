package com.cyber_guardians.Cyber_Guardians.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PasswordEvaluationResponse {
    private String crackingTime; // 남김
    private List<String> recommendations;

    public PasswordEvaluationResponse(String crackingTime, List<String> recommendations) {
        this.crackingTime = crackingTime;
        this.recommendations = recommendations;
    }

}
