package com.airportService.backend.services;

import com.airportService.backend.models.BoardingCheck;
import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.models.LuggageType;
import com.airportService.backend.repositories.BoardingPassRepository;
import com.airportService.backend.repositories.LuggageTypeRepository;
import com.airportService.backend.repositories.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardingServiceImpl implements BoardingService {
    @Autowired
    private final LuggageTypeRepository luggageTypeRepository;
    @Autowired
    private final BoardingPassRepository boardingPassRepository;
    @Autowired
    private final SecurityRepository securityRepository;

    public BoardingServiceImpl(LuggageTypeRepository luggageTypeRepository, BoardingPassRepository boardingPassRepository, SecurityRepository securityRepository) {
        this.luggageTypeRepository = luggageTypeRepository;
        this.boardingPassRepository = boardingPassRepository;
        this.securityRepository = securityRepository;
    }

    @Override
    public void addLuggageType(LuggageType luggageType) {
        luggageTypeRepository.save(luggageType);
    }

    @Override
    public LuggageType findLuggageTypeById(Long id) {
        return luggageTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void addBoardingPass(BoardingPass boardingPass) {
        BoardingCheck securityRecord = new BoardingCheck();
        securityRecord.setBoardingPass(boardingPass);
        securityRecord.setCheckResult(false);
        boardingPassRepository.save(boardingPass);
        securityRepository.save(securityRecord);
    }
}
