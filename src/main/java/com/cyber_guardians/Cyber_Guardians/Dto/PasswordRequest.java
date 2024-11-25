package com.cyber_guardians.Cyber_Guardians.Dto;

import lombok.Getter;

@Getter
public class PasswordRequest {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
