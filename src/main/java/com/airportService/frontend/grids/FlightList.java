package com.airportService.frontend.grids;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.modelsLight.FlightLight;
import com.airportService.frontend.components.TicketForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "flights")
@PageTitle("Flights")
public class FlightList extends VerticalLayout {
    @Autowired
    private final MainFlightController mainFlightController;

    private Grid<FlightLight> employeeGrid= new Grid<>(FlightLight.class);
    private final TextField filter = new TextField();
    private final HorizontalLayout toolbar = new HorizontalLayout(filter);
    H1 text = new H1("Buy aviatickets based on destination online");

    @Autowired
    public FlightList(MainFlightController mainFlightController) {
        this.mainFlightController = mainFlightController;
        filter.setPlaceholder("Destination");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        add(text, toolbar, employeeGrid);

        employeeGrid.addComponentColumn(e -> {
            Button button = new Button("Get ticket");
            button.addClickListener(event -> add(new TicketForm(mainFlightController, e)));
            return button;
        });
        fillList("");
    }

    private void fillList(String name) {
        if (name.isEmpty()) {
            employeeGrid.setItems(this.mainFlightController.getFlightsLight());
        } else {
            employeeGrid.setItems(this.mainFlightController.getFlightsOnDestAirport(name));
        }
    }
}

