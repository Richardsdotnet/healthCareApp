package org.example.healthCare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    private String name;
    private String email;
    private String password;
}
