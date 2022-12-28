package com.airportService.frontend.pages;

import com.airportService.backend.controllers.FlightController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.grids.FlightTimeGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("hello")
public class FlightTimePage extends VerticalLayout {
    @Autowired
    private final FlightController mainFlightController;
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout center = new HorizontalLayout();
    Button fuelReport = new Button("fuel report");
    Button flightsOnTimeInterval = new Button("flights info");
    HeaderStuff header = new HeaderStuff(fuelReport, flightsOnTimeInterval, "fuel", "time");
    Footer footer = new Footer();
    private FlightTimeGrid flightTimeList;
    private H1 fuelReportText = new H1("Report based on flights in the given interval");

    public FlightTimePage(FlightController mainFlightController) {
        this.mainFlightController = mainFlightController;
        flightTimeList = new FlightTimeGrid(mainFlightController);
        content.setPadding(false);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        center.setWidth("100%");
        content.setWidth("100%");
        content.getElement().getStyle().set("padding", "70px 90px");
        content.add(fuelReportText, flightTimeList);
        add(header, content, footer);
    }
}

