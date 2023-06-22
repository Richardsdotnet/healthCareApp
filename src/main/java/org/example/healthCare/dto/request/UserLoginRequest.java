package org.example.healthCare.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {
    private String email;
    private String password;
    private boolean isLoggedIn;
}
