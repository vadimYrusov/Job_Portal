package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepo extends JpaRepository<Form, Long> {

    Form getFormById(Long id);
}
