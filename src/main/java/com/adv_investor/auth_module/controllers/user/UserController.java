package com.adv_investor.auth_module.controllers.user;

import com.adv_investor.auth_module.domain.user.User;
import com.adv_investor.auth_module.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody @Valid User user) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.ok(repository.save(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patch(@PathVariable String id, @RequestBody User partial) {
        return repository.findById(id)
                .map(existing -> {
                    if (partial.getName() != null) existing.setName(partial.getName());
                    if (partial.getEmail() != null) existing.setEmail(partial.getEmail());
                    if (partial.getPassword() != null) existing.setPassword(partial.getPassword());
                    if (partial.getProfile() != null) existing.setProfile(partial.getProfile());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
