package com.footbooking.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest (

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "^[0-9]{8}$", message = "Phone number must be exactly 8 digits")
    String phone,

    @NotBlank
    String fullname,

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password
) {}
