package com.adv_investor.auth_module.infra.repositories;

import com.adv_investor.auth_module.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByCpfDocument(String cpfDocument);
}
