package org.example.healthCare.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationResponse {
    String message;
    private String id;
    private  String  name;
}
