package com.hotelbooking.repository;

import com.hotelbooking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role_user);

    boolean existsByName(String role);
}
