package com.airportService.backend.controllers;

import com.airportService.backend.models.BoardingCheck;
import com.airportService.backend.services.BoardingCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BoardingControlController {
    @Autowired
    private final BoardingCheckServiceImpl boardingCheckService;

    public BoardingControlController(BoardingCheckServiceImpl boardingCheckService) {
        this.boardingCheckService = boardingCheckService;
    }

    public void addRecord(BoardingCheck boardingCheck) {
        boardingCheckService.addRecord(boardingCheck);
    }

    public List<BoardingCheck> findAll() {
        return boardingCheckService.findAll();
    }

    public void updateComments(Long id, String comments) {
        boardingCheckService.updateComments(id, comments);
    }

    public void updateToChecked(Long id) {
        boardingCheckService.updateToChecked(id);
    }

    public List<BoardingCheck> getRecordByBoardingPassQRCode(String qrCode) {
        return boardingCheckService.getRecordByBoardingPassQRCode(qrCode);
    }
}
