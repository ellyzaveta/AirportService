package com.airportService.frontend.grids;

import com.airportService.backend.controllers.BoardingControlController;
import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.backend.models.BoardingCheck;
import com.airportService.frontend.components.BoardingControlForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("boardingCheck")
public class BoardingControlGrid extends VerticalLayout {
    @Autowired
    private final BoardingControlController boardingCheckController;
    @Autowired
    private final BoardingPassController boardingPassController;
    private Grid<BoardingCheck> grid = new Grid<>(BoardingCheck.class);
    private TextField filter = new TextField();
    private final H1 heading = new H1("Boarding control");
    public BoardingControlGrid(BoardingControlController boardingCheckController, BoardingPassController boardingPassController) {
        this.boardingCheckController = boardingCheckController;
        this.boardingPassController = boardingPassController;
        filter.setPlaceholder("Boarding pass QR code");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        filter.setWidth("220px");
        grid.addComponentColumn(e -> {
            Button button = new Button("check");
            button.addClickListener(event -> add(new BoardingControlForm(boardingCheckController, boardingPassController, e)));
            return button;
        });
        grid.getElement().getStyle().set("box-shadow", "0px 4px 20px rgba(0, 0, 0, 0.25)");
        fillList("");
        heading.getElement().getStyle().set("margin-top", "0");
        add(heading, filter, grid);
    }

    public void fillList(String filter) {
        if(filter.isEmpty()) {
            grid.setItems(boardingCheckController.findAll());
        }
        else {
            grid.setItems(boardingCheckController.getRecordByBoardingPassQRCode(filter));
        }
    }
}

