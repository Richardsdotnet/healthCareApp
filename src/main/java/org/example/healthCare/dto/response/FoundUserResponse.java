package org.example.healthCare.dto.response;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class FoundUserResponse {
    private String name;
    private String email;
    private String password;
}
