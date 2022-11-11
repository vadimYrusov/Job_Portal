package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepo extends JpaRepository<Vacancy, Long> {

    Vacancy getVacancyById(Long id);

    List<Vacancy> getByNameContainsIgnoreCase(@Param("keyword") String keyword);
}
