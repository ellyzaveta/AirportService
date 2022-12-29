package com.airportService.backend.services;

import com.airportService.backend.models.BoardingCheck;

import java.util.List;

public interface BoardingCheckService {
    void addRecord(BoardingCheck boardingCheck);
    List<BoardingCheck> findAll();
    void updateComments(Long id, String comments);
    void updateToChecked(Long id);
    List<BoardingCheck> getRecordByBoardingPassQRCode(String qrCode);
}
