package com.adv_investor.auth_module.application.factory;

import com.adv_investor.auth_module.domain.user.User;
import com.adv_investor.auth_module.application.dto.UserDTO;

public final class UserFactory {

    private UserFactory() {}

    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getCpfDocument(),
                user.getEmail(),
                user.getIsActive(),
                user.getProfile()
        );
    }

    public static User fromDto(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.id());
        user.setName(dto.name());
        user.setCpfDocument(dto.cpfDocument());
        user.setEmail(dto.email());
        user.setIsActive(dto.isActive());
        user.setProfile(dto.profile());
        return user;
    }
}
