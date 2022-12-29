package com.airportService.backend.repositories;

import com.airportService.backend.models.BoardingCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<BoardingCheck, Long> {
}

