package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role getRoleById(Long id);
}
