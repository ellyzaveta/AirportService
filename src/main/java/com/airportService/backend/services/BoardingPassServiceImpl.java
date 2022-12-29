package com.airportService.backend.services;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.modelsLight.BoardingPassForm;
import com.airportService.backend.repositories.BoardingPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {
    @Autowired
    private final BoardingPassRepository boardingPassRepository;

    public BoardingPassServiceImpl(BoardingPassRepository boardingPassRepository) {
        this.boardingPassRepository = boardingPassRepository;
    }

    @Override
    public void addBoardingPass(BoardingPass boardingPass) {
        boardingPassRepository.save(boardingPass);
    }

    @Override
    public List<BoardingPass> findAll() {
        return boardingPassRepository.findAll();
    }

    @Override
    public BoardingPass findById(Long id) {
        return boardingPassRepository.findById(id).orElse(null);
    }

    @Override
    public BoardingPassForm getBoardingPassForm(Long id) {
        return boardingPassRepository.getBoardingPassForm(id);
    }

    @Override
    public void setIsCheckedToTrue(Long id) {
        boardingPassRepository.setIsCheckedToTrue(id);
    }
}
