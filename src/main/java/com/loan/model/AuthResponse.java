package com.loan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Containes the response received by Auth Microservice
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    //column
    private String username;

    //columnjbjb
    private String role;

    //column
    private boolean isValid;

    public AuthResponse(String user, String user1, boolean b) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
