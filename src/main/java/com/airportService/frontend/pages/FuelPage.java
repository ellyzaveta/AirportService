package com.airportService.frontend.pages;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.modelsLight.FlightFuel;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

public class FuelPage extends VerticalLayout {
    @Autowired
    private final MainFlightController mainFlightController;
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout center = new HorizontalLayout();
    Button fuelReport = new Button("fuel report");
    Button flightsOnTimeInterval = new Button("flights info");
    HeaderStuff header = new HeaderStuff(fuelReport, flightsOnTimeInterval, "fuel", "time");
    Footer footer = new Footer();
    private Grid<FlightFuel> fuelGrid = new Grid<>(FlightFuel.class);
    private VerticalLayout verticalLayout = new VerticalLayout();
    private H1 fuelReportText = new H1("Fuel report based on flights and aircraft models");

    public FuelPage(MainFlightController mainFlightController) {
        this.mainFlightController = mainFlightController;
        fuelGrid.setItems(mainFlightController.getFuelReport());
        fuelGrid.getElement().getStyle().set("box-shadow", "0px 4px 20px rgba(0, 0, 0, 0.25)");
        fuelGrid.setHeight("600px");
        content.setPadding(false);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        center.setWidth("100%");
        content.setWidth("100%");
        content.getElement().getStyle().set("padding", "70px 90px");
        content.add(fuelReportText, fuelGrid);
        add(header, content, footer);
    }
}

