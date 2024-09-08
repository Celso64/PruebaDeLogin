package com.jwt.login.controller;


import com.jwt.login.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hola")
    public ResponseEntity<String> saludar(){
        // Obtener la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar si el usuario está autenticado y es una instancia de User
        if (authentication != null && authentication.getPrincipal() instanceof User user) {

            // Obtener el fullname del usuario
            String fullName = user.getFullName();

            // Obtener los roles del usuario
            String roles = user.getAuthorities().stream()
                    .map(authority -> authority.getAuthority().replace("ROLE_", "")) // Eliminar el prefijo "ROLE_"
                    .reduce((role1, role2) -> role1 + ", " + role2) // Combinar roles en una cadena
                    .orElse("SIN_ROL"); // Si no hay roles, mostrar "SIN_ROL"

            // Retornar el mensaje personalizado con el fullname y los roles
            return ResponseEntity.ok("HOLA " + fullName + " (" + roles + ")");
        }

        // Si el usuario no está autenticado o no es una instancia de User
        return ResponseEntity.ok("HOLA USUARIO");
    }
}
