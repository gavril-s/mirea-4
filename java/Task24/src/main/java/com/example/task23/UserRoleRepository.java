package com.example.task23;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole getUserRoleById(Long userId);
}
