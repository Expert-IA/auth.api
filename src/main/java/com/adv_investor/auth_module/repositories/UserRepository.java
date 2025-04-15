package com.adv_investor.auth_module.repositories;

import com.adv_investor.auth_module.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByCpfDocument(String cpfDocument);
}
