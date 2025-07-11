package com.adv_investor.auth_module.domain.user;

public record RegisterDTO(String cpfDocument,
                          String name,
                          String password,
                          String email,
                          Boolean isActive,
                          UserProfile profile) { }
