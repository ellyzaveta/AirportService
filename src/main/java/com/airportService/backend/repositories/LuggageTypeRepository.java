package com.airportService.backend.repositories;

import com.airportService.backend.models.LuggageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageTypeRepository extends JpaRepository<LuggageType, Long> {
}
