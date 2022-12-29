package com.airportService.backend.services;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.modelsLight.BoardingPassForm;

import java.util.List;

public interface BoardingPassService {
    void addBoardingPass(BoardingPass boardingPass);
    List<BoardingPass> findAll();
    BoardingPass findById(Long id);
    BoardingPassForm getBoardingPassForm(Long id);
    void setIsCheckedToTrue(Long id);
}
