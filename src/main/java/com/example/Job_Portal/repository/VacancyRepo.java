package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepo extends JpaRepository<Vacancy, Long> {

    Vacancy getVacancyById(Long id);
}
