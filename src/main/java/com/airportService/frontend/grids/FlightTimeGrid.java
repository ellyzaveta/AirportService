package com.airportService.frontend.grids;

import com.airportService.backend.controllers.FlightController;
import com.airportService.backend.modelsLight.FlightTime;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FlightTimeGrid extends VerticalLayout {
    @Autowired
    private final FlightController mainFlightController;

    private Grid<FlightTime> grid = new Grid<>(FlightTime.class);
    private final DatePicker dateLow = new DatePicker("low boundary of interval");
    private final DatePicker dateHigh = new DatePicker("high boundary of interval");
    private final Button find = new Button("find flights");
    private final HorizontalLayout toolbar = new HorizontalLayout(dateLow, dateHigh, find);
    private final H1 heading = new H1("Flights departure on the given time interval");

    @Autowired
    public FlightTimeGrid(FlightController mainFlightController) {
        setPadding(false);
        this.mainFlightController = mainFlightController;
        find.addClickListener(event -> fillList(dateLow.getValue(), dateHigh.getValue()));
        find.getElement().getStyle().set("margin-top", "36px");
        add(heading, toolbar, grid);
        grid.getElement().getStyle().set("box-shadow", "0px 4px 30px rgba(0, 0, 0, 0.25)");
        heading.getElement().getStyle().set("margin-top", "0");
        fillList(null, null);
    }

    private void fillList(LocalDate low, LocalDate high) {
        if (low == null || high == null) {
            grid.setItems(this.mainFlightController.getTimeInterval());
        } else {
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Date lowDate = Date.from(low.atStartOfDay(defaultZoneId).toInstant());
            Date highDate = Date.from(high.atStartOfDay(defaultZoneId).toInstant());
            grid.setItems(this.mainFlightController.getTimeInterval(lowDate, highDate));
        }
    }
}
