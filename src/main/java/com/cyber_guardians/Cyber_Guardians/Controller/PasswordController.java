package com.cyber_guardians.Cyber_Guardians.Controller;

import com.cyber_guardians.Cyber_Guardians.Dto.PasswordEvaluationResponse;
import com.cyber_guardians.Cyber_Guardians.Dto.PasswordRequest;
import com.cyber_guardians.Cyber_Guardians.Service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/evaluate")
    public ResponseEntity<PasswordEvaluationResponse> evaluatePassword(@RequestBody PasswordRequest request) {
        PasswordEvaluationResponse response = passwordService.evaluatePassword(request.getPassword());
        return ResponseEntity.ok(response);
    }
}
