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

    @CrossOrigin(origins = "https://port-0-gsm-cyber-guardians-m3wt730naaaf171b.sel4.cloudtype.app/")
    @PostMapping("/evaluate")
    public ResponseEntity<PasswordEvaluationResponse> evaluatePassword(@RequestBody PasswordRequest request) {
        PasswordEvaluationResponse response = passwordService.evaluatePassword(request.getPassword());
        return ResponseEntity.ok(response);
    }
}