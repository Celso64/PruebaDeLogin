package com.jwt.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRegistro(
        @NotEmpty(message = "Nombre obligatorio.") String fullName,
        @Email(message = "Debe ser un email valido.") String email,
        @NotEmpty(message = "Password obligatoria.") String password) {
}
