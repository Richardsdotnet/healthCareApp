package org.example.healthCare.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    private String name;
    private String id;
    private String emailAddress;
    private String password;


}
