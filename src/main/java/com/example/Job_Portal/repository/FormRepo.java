package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormRepo extends JpaRepository<Form, Long> {

    Form getFormById(Long id);

    List<Form> getByNameContainsIgnoreCase(@Param("keyword") String keyword);
}
