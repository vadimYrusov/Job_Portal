package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category getCategoryById(Long id);
}
