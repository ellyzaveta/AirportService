package com.airportService.backend.services;

import com.airportService.backend.models.BoardingCheck;
import com.airportService.backend.repositories.BoardingCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingCheckServiceImpl implements BoardingCheckService{
    @Autowired
    private final BoardingCheckRepository boardingCheckRepository;

    public BoardingCheckServiceImpl(BoardingCheckRepository boardingCheckRepository) {
        this.boardingCheckRepository = boardingCheckRepository;
    }

    @Override
    public void addRecord(BoardingCheck boardingCheck) {
        boardingCheckRepository.save(boardingCheck);
    }

    @Override
    public List<BoardingCheck> findAll() {
        return boardingCheckRepository.findAll();
    }

    @Override
    public void updateComments(Long id, String comments) {
        boardingCheckRepository.updateComments(id, comments);
    }

    @Override
    public void updateToChecked(Long id) {
        boardingCheckRepository.updateToChecked(id);
    }

    @Override
    public List<BoardingCheck> getRecordByBoardingPassQRCode(String qrCode) {
        return boardingCheckRepository.getRecordByBoardingPassQRCode(qrCode);
    }
}

