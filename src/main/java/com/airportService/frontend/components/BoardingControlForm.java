package com.airportService.frontend.components;

import com.airportService.backend.controllers.BoardingControlController;
import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.backend.models.BoardingCheck;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BoardingControlForm extends HorizontalLayout {
    private final BoardingControlController boardingCheckController;
    private final BoardingPassController boardingPassController;
    private final Checkbox checkResult = new Checkbox("Successful");
    private final TextField comments = new TextField("Comments");
    private final Button save = new com.vaadin.flow.component.button.Button("Save");
    private final Button cancel = new Button("Cancel");
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final HorizontalLayout toolBar = new HorizontalLayout();
    private final Label firstName;
    private final Label lastName;
    private final Label passportNumber;
    private final Label flightNumber;
    private final Label qrCode;
    private final VerticalLayout form = new VerticalLayout();
    private final BoardingCheck boardingCheck;
    public BoardingControlForm(BoardingControlController boardingCheckController, BoardingPassController boardingPassController, BoardingCheck boardingCheck) {
        this.boardingCheckController = boardingCheckController;
        this.boardingPassController = boardingPassController;
        this.boardingCheck = boardingCheck;

        firstName = new Label("First name: " + boardingCheck.getBoardingPass().getTicket().getPassenger().getFirstName());
        lastName = new Label("Last name: " + boardingCheck.getBoardingPass().getTicket().getPassenger().getLastName());
        passportNumber = new Label("Passport number: " + boardingCheck.getBoardingPass().getTicket().getPassenger().getPassportNumber());
        flightNumber = new Label("Flight number: " + boardingCheck.getBoardingPass().getTicket().getFlight().getFlightNumber());
        qrCode = new Label("QRcode: " + boardingCheck.getBoardingPass().getQrCode());
        form.add(firstName, lastName, passportNumber, flightNumber, qrCode);

        cancel.addClickListener(e -> setVisible(false));
        save.addClickListener(e -> save());
        toolBar.add(save, cancel);

        verticalLayout.add(checkResult, comments, toolBar);
        verticalLayout.getElement().getStyle().set("margin-top", "5px");

        this.setWidth("50%");
        this.getElement().getStyle()
                .set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("background", "white");

        add(form, verticalLayout);
    }

    public void save() {
        if(!boardingCheck.isCheckResult()) {
            if (checkResult.getValue()) {
                boardingPassController.setIsCheckedToTrue(boardingCheck.getBoardingPass().getId());
                boardingCheckController.updateToChecked(boardingCheck.getId());
                if (comments.getValue() != null) {
                    boardingCheckController.updateComments(boardingCheck.getId(), comments.getValue());
                }
            }
            else {
                if (comments.getValue() != null) {
                    boardingCheckController.updateComments(boardingCheck.getId(), comments.getValue());
                }
            }
            setVisible(false);
        }
    }
}

