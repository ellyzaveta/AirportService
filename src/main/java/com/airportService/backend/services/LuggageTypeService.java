package com.airportService.backend.services;

import com.airportService.backend.models.LuggageType;

import java.util.List;

public interface LuggageTypeService {
    void addLuggageType(LuggageType luggageType);
    LuggageType findById(Long id);
    List<LuggageType> findAll();
}
