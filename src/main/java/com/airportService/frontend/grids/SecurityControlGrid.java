package com.airportService.frontend.grids;

import com.airportService.backend.controllers.SecurityControlController;
import com.airportService.backend.models.SecurityControl;
import com.airportService.frontend.components.SecurityControlForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("securityControl")
public class SecurityControlGrid extends VerticalLayout {
    @Autowired
    private final SecurityControlController securityControlController;
    private Grid<SecurityControl> grid = new Grid<>(SecurityControl.class);
    private TextField filter = new TextField();
    private H1 heading = new H1("Security control");
    public SecurityControlGrid(SecurityControlController securityControlController) {
        this.securityControlController = securityControlController;
        filter.setPlaceholder("Passport number");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        grid.addComponentColumn(e -> {
            Button button = new Button("check");
            button.addClickListener(event -> add(new SecurityControlForm(securityControlController, e)));
            return button;
        });
        fillList("");
        heading.getElement().getStyle().set("margin-top", "0");
        add(heading, filter, grid);
    }

    public void fillList(String filter) {
        if(filter.isEmpty()) {
            grid.setItems(securityControlController.findAll());
        }
        else {
            grid.setItems(securityControlController.getRecordByPassport(filter));
        }
    }
}
