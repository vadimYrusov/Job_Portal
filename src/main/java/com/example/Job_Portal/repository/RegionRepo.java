package com.example.Job_Portal.repository;

import com.example.Job_Portal.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, Long> {

    Region getRegionById(Long id);
}
