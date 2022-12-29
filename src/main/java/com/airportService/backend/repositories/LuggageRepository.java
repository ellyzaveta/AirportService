package com.airportService.backend.repositories;

import com.airportService.backend.models.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {
}
