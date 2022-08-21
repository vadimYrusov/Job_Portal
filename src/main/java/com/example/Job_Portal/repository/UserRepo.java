package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
