package com.airportService.backend.services;

import com.airportService.backend.models.LuggageType;
import com.airportService.backend.repositories.LuggageTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuggageTypeServiceImpl implements LuggageTypeService{
    private final LuggageTypeRepository luggageTypeRepository;

    public LuggageTypeServiceImpl(LuggageTypeRepository luggageTypeRepository) {
        this.luggageTypeRepository = luggageTypeRepository;
    }

    @Override
    public void addLuggageType(LuggageType luggageType) {
        luggageTypeRepository.save(luggageType);
    }

    @Override
    public LuggageType findById(Long id) {
        return luggageTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<LuggageType> findAll() {
        return luggageTypeRepository.findAll();
    }
}
