package com.airportService.backend.controllers;

import com.airportService.backend.models.BoardingCheck;
import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.models.Passenger;
import com.airportService.backend.modelsLight.BoardingPassForm;
import com.airportService.backend.services.BoardingPassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BoardingPassController {
    @Autowired
    private final BoardingPassServiceImpl boardingPassService;
    @Autowired
    private final BoardingControlController boardingCheckController;
    @Autowired
    private final TicketController ticketController;

    public BoardingPassController(BoardingPassServiceImpl boardingPassService, BoardingControlController boardingCheckController, TicketController ticketController) {
        this.boardingPassService = boardingPassService;
        this.boardingCheckController = boardingCheckController;
        this.ticketController = ticketController;
    }

    public void addBoardingPass(BoardingPass boardingPass) {
        Passenger passenger = boardingPass.getTicket().getPassenger();
        BoardingCheck securityRecord = new BoardingCheck();
        securityRecord.setBoardingPass(boardingPass);
        //securityRecord.setPassenger(passenger);
        boardingPassService.addBoardingPass(boardingPass);
        ticketController.setHasBoardingPassToTrue(boardingPass.getTicket().getId());
        boardingCheckController.addRecord(securityRecord);
    }

    public List<BoardingPass> findAll() {
        return boardingPassService.findAll();
    }

    public BoardingPass findById(Long id) {
        return boardingPassService.findById(id);
    }

    public BoardingPassForm getBoardingPassForm(Long id) {
        return boardingPassService.getBoardingPassForm(id);
    }

    public void setIsCheckedToTrue(Long id) {
        boardingPassService.setIsCheckedToTrue(id);
    }
}
