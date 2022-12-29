package com.airportService.frontend.grids;

import com.airportService.backend.controllers.PassportControlController;
import com.airportService.backend.models.PassportControl;
import com.airportService.frontend.components.PassportControlForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("passportControl")
public class PassportControlGrid extends VerticalLayout {
    @Autowired
    private final PassportControlController passportControlController;
    private Grid<PassportControl> grid = new Grid<>(PassportControl.class);
    private TextField filter = new TextField();
    private H1 heading = new H1("Passport control");
    public PassportControlGrid(PassportControlController passportControlController) {
        this.passportControlController = passportControlController;
        filter.setPlaceholder("Passport number");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        grid.addComponentColumn(e -> {
            Button button = new Button("check");
            button.addClickListener(event -> add(new PassportControlForm(passportControlController, e)));
            return button;
        });
        grid.getElement().getStyle().set("box-shadow", "0px 4px 20px rgba(0, 0, 0, 0.25)");
        fillList("");
        heading.getElement().getStyle().set("margin-top", "0");
        add(heading, filter, grid);
    }

    public void fillList(String filter) {
        if(filter.isEmpty()) {
            grid.setItems(passportControlController.findAll());
        }
        else {
            grid.setItems(passportControlController.getRecordByPassport(filter));
        }
    }
}

