package com.sai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestModel{

    @NotNull(message = "first name cannot be null")
    @Size(min = 2, message = "first name not must be less than 2 characters")
    private String firstName;


    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name not must be less than 2 characters")
    private String lastName;


    @NotNull(message = "Password cannot be null")
    @Size(min = 8,max=16,  message = "Password must be min of 8 character to 16 characters in length")
    private  String password;

    @NotNull(message = "email cannot be empty")
    @Email
    private String email;
}
