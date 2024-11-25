package com.cyber_guardians.Cyber_Guardians.Controller;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;
import com.cyber_guardians.Cyber_Guardians.Dto.PasswordRequest;
import com.cyber_guardians.Cyber_Guardians.Service.PasswordEvaluator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordEvaluationController {

    @PostMapping("/evaluate")
    public ResponseEntity<PasswordEvaluationResponse> evaluatePassword(@RequestBody PasswordRequest request) {
        String password = request.getPassword();

        // 비밀번호 점수 평가 로직
        PasswordEvaluator evaluator = new PasswordEvaluator();
        PasswordEvaluationResponse response = evaluator.evaluate(password);

        return ResponseEntity.ok(response);
    }
}
