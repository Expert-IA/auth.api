package com.adv_investor.auth_module.domain.dao;

import com.adv_investor.auth_module.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);
    void deleteById(String id);
    boolean existsById(String id);
}
