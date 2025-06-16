package com.adv_investor.auth_module.application.dto;

import com.adv_investor.auth_module.domain.user.UserProfile;

public record UserDTO(String id,
                      String name,
                      String cpfDocument,
                      String email,
                      Boolean isActive,
                      UserProfile profile) {
}
