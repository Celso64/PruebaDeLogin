package com.jwt.login.service;

import com.jwt.login.dto.UserLogin;
import com.jwt.login.dto.UserRegistro;
import com.jwt.login.entity.Rol;
import com.jwt.login.entity.User;
import com.jwt.login.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User altaComun(UserRegistro u){
        return signup(u, Rol.COMUN);
    }

    public User altaAdmin(UserRegistro u){
        return signup(u, Rol.ADMIN);
    }

    private User signup(UserRegistro input, Rol rol) {
        User user = User.builder()
                .fullName(input.fullName())
                .email(input.email())
                .roles(Set.of(rol))
                .password(passwordEncoder.encode(input.password()))
                .build();

        return userRepository.save(user);
    }

    public User authenticate(UserLogin input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }
}
