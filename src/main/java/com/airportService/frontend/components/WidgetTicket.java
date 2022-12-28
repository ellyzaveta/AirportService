package com.airportService.frontend.components;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.modelsLight.TicketWidget;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;

public class WidgetTicket extends VerticalLayout {
    @Autowired
    private final MainFlightController mainFlightController;

    private final Grid<TicketWidget> employeeGrid = new Grid<>(TicketWidget.class);
    private final TextField filter = new TextField();
    private final HorizontalLayout holder = new HorizontalLayout();
    private final H3 numOfAvailablePlaces = new H3("Number of available tickets based on destination");
    public WidgetTicket(MainFlightController mainFlightController) {
        this.mainFlightController = mainFlightController;
        filter.getElement().getStyle().set("margin-top", "20px");
        holder.add(numOfAvailablePlaces, filter);
        filter.setPlaceholder("Destination");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        employeeGrid.getElement().getStyle().set("border-radius", "10px");
        this.getElement().getStyle().set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("background", "white")
                .set("border-radius", "10px");
        this.setPadding(false);
        holder.getElement().getStyle().set("padding-left", "25px");
        holder.getElement().getStyle().set("padding-right", "15px");
        add(holder, employeeGrid);
        fillList("");
    }

    public void fillList(String filter) {
        if (filter.isEmpty()) {
            employeeGrid.setItems(this.mainFlightController.getTicketWidget());
        } else {
            employeeGrid.setItems(this.mainFlightController.getTicketWidgetBasedOnAirport(filter));
        }
    }
}

