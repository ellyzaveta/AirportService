package com.airportService.frontend.pages;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.modelsLight.FlightFuel;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Fuel report")
@Route("fuel")
public class FuelReportPage extends VerticalLayout {
    @Autowired
    private final MainFlightController mainFlightController;
    HeaderStuff header;
    Footer footer = new Footer();
    private final Button button1 = new Button("flights");
    private final Button button2 = new Button("fuel report");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    private Grid<FlightFuel> grid = new Grid<>(FlightFuel.class);
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up.png", "up");
    private final Image bottom = new Image("images/bottom.png", "bottom");
    VerticalLayout background = new VerticalLayout();
    private final H1 heading = new H1("Fuel report");
    private final TextField filter = new TextField();

    public FuelReportPage(MainFlightController mainFlightController) {
        filter.setPlaceholder("aircraft model");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));
        this.mainFlightController = mainFlightController;
        fillList("");
        grid.getElement().getStyle().set("box-shadow", "0px 4px 20px rgba(0, 0, 0, 0.25)");
        verticalLayout.getElement().getStyle().set("background", "rgba(236, 243, 249, 1)");
        header = new HeaderStuff(button1, button2, "time", "fuel");
        content.setPadding(false);
        content.setWidth("100%");
        content.add(main);
        content.setPadding(false);
        verticalLayout.getElement().getStyle().set("padding", "0px 90px");
        verticalLayout.add(heading, filter, grid);
        heading.getElement().getStyle().set("margin-top", "0");
        background.add(up, verticalLayout, bottom);
        background.setPadding(false);
        background.getElement().getStyle().set("padding-top", "90px")
                .set("padding-bottom", "70px");
        content.add(background);
        verticalLayout.getElement().getStyle().set("margin-top", "-10px");
        bottom.getElement().getStyle().set("margin-top", "0px");
        add(header, content, footer);
        this.setPadding(false);
    }

    private void fillList(String filter) {
        if (filter.isEmpty()) {
            grid.setItems(mainFlightController.getFuelReport());
        } else {
            grid.setItems(mainFlightController.getFuelReportBasedOnModel(filter));
        }
    }
}
