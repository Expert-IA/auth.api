package com.adv_investor.auth_module.application.usecase;

import com.adv_investor.auth_module.domain.dao.UserDao;
import com.adv_investor.auth_module.domain.user.User;
import com.adv_investor.auth_module.application.dto.UserDTO;
import com.adv_investor.auth_module.application.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserUseCase {

    private final UserDao userDao;

    @Autowired
    public UserUseCase(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserDTO> listUsers() {
        return userDao.findAll()
                .stream()
                .map(UserFactory::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getById(String id) {
        return userDao.findById(id)
                .map(UserFactory::toDto)
                .orElse(null);
    }

    public UserDTO save(User user) {
        return UserFactory.toDto(userDao.save(user));
    }

    public UserDTO update(String id, User user) {
        if (!userDao.existsById(id)) {
            return null;
        }
        user.setId(id);
        return UserFactory.toDto(userDao.save(user));
    }

    public UserDTO patch(String id, User partial) {
        return userDao.findById(id)
                .map(existing -> {
                    if (partial.getName() != null) existing.setName(partial.getName());
                    if (partial.getEmail() != null) existing.setEmail(partial.getEmail());
                    if (partial.getPassword() != null) existing.setPassword(partial.getPassword());
                    if (partial.getProfile() != null) existing.setProfile(partial.getProfile());
                    if (partial.getIsActive() != null) existing.setIsActive(partial.getIsActive());
                    return UserFactory.toDto(userDao.save(existing));
                })
                .orElse(null);
    }

    public boolean delete(String id) {
        if (!userDao.existsById(id)) {
            return false;
        }
        userDao.deleteById(id);
        return true;
    }
}
