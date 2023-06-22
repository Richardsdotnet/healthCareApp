package org.example.healthCare.dto.request;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserRegistrationRequest {
    private String name;
    private String EmailAddress;
    private String password;


}
