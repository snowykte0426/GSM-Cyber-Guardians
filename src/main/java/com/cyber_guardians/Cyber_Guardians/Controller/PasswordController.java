package com.cyber_guardians.Cyber_Guardians.Controller;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;
import com.cyber_guardians.Cyber_Guardians.Dto.PasswordRequest;
import com.cyber_guardians.Cyber_Guardians.Service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<PasswordEvaluationResponse> evaluatePassword(@RequestBody PasswordRequest request) {
        PasswordEvaluationResponse response = passwordService.evaluatePassword(request.getPassword());
        return ResponseEntity.ok(response);
    }
}
