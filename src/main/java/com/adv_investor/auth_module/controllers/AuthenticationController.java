package com.adv_investor.auth_module.controllers;

import com.adv_investor.auth_module.domain.user.RegisterDTO;
import com.adv_investor.auth_module.domain.user.User;
import com.adv_investor.auth_module.repositories.UserRepository;
import jakarta.validation.Valid;
import com.adv_investor.auth_module.domain.user.AuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var userPassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = this.authenticationManager.authenticate(userPassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        System.out.println(data);

        if (repository.findByCpfDocument(data.cpfDocument()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        String encodedPassword = new BCryptPasswordEncoder().encode(data.cpfDocument());
        User newUser = new User(data.cpfDocument(), data.name(), encodedPassword, data.email(), data.profile());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
