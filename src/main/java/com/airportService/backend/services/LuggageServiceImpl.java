package com.airportService.backend.services;

import com.airportService.backend.models.Luggage;
import com.airportService.backend.repositories.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuggageServiceImpl implements LuggageService{
    @Autowired
    private final LuggageRepository luggageRepository;

    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }

    @Override
    public void addLuggage(Luggage luggage) {
        luggageRepository.save(luggage);
    }
}

