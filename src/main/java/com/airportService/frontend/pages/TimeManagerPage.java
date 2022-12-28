package com.airportService.frontend.pages;

import com.airportService.backend.controllers.FlightController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.grids.FlightTimeGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("time")
public class TimeManagerPage extends VerticalLayout {
    @Autowired
    private final FlightController mainFlightController;
    HeaderStuff header;
    Footer footer = new Footer();
    private final Button button1 = new Button("flights");
    private final Button button2 = new Button("fuel report");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    FlightTimeGrid grid;
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up.png", "up");
    private final Image bottom = new Image("images/bottom.png", "bottom");
    VerticalLayout background = new VerticalLayout();

    public TimeManagerPage(FlightController mainFlightController) {
        this.mainFlightController = mainFlightController;
        grid = new FlightTimeGrid(mainFlightController);
        grid.getElement().getStyle().set("background", "rgba(236, 243, 249, 1)");
        header = new HeaderStuff(button1, button2, "time", "fuel");
        content.setPadding(false);
        content.setWidth("100%");
        content.add(main);
        content.setPadding(false);
        grid.getElement().getStyle().set("padding", "0px 90px");
        background.add(up, grid, bottom);
        background.setPadding(false);
        background.getElement().getStyle().set("padding-top", "90px")
                .set("padding-bottom", "70px");
        content.add(background);
        grid.getElement().getStyle().set("margin-top", "-10px");
        bottom.getElement().getStyle().set("margin-top", "0px");
        add(header, content, footer);
        this.setPadding(false);
    }
}
