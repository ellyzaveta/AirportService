package com.airportService.frontend.components;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.modelsLight.TimeWidget;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class WidgetTime extends VerticalLayout {
    @Autowired
    private final MainFlightController mainFlightController;

    private Grid<TimeWidget> employeeGrid = new Grid<>(TimeWidget.class);
    private HorizontalLayout holder = new HorizontalLayout();
    H3 departureTime = new H3("Flights departing within the next two hours");
    public WidgetTime(MainFlightController mainFlightController) {
        holder.add(departureTime);
        holder.getElement().getStyle().set("padding-left", "25px");
        this.getElement().getStyle()
                .set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("border-radius", "10px")
                .set("background", "white");
        this.mainFlightController = mainFlightController;
        employeeGrid.setItems(mainFlightController.getFlightsToDepartureLessThanIn2Hours());
        employeeGrid.getElement().getStyle().set("border-radius", "10px");
        this.setPadding(true);
        add(holder, employeeGrid);
    }
}
