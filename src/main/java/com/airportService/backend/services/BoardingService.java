package com.airportService.backend.services;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.models.LuggageType;

public interface BoardingService {
    void addLuggageType(LuggageType luggageType);
    LuggageType findLuggageTypeById(Long id);
    void addBoardingPass(BoardingPass boardingPass);
}
