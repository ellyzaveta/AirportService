package com.airportService.frontend.pages;

import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.backend.controllers.LuggageController;
import com.airportService.backend.controllers.LuggageTypeController;
import com.airportService.backend.controllers.TicketController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.grids.TicketGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("registration")
public class BoardingManagerPage extends VerticalLayout {
    @Autowired
    private final TicketController ticketController;
    @Autowired
    private final BoardingPassController boardingPassController;
    @Autowired
    private final LuggageTypeController luggageTypeController;
    @Autowired
    private final LuggageController luggageController;
    HeaderStuff header;
    Footer footer = new Footer();
    private final Button button1 = new Button("check-in");
    private final Button button2 = new Button("control");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    TicketGrid ticketGrid;
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up4.png", "up");
    private final Image bottom = new Image("images/bottom4.png", "bottom");
    VerticalLayout background = new VerticalLayout();

    public BoardingManagerPage(TicketController ticketController, BoardingPassController boardingPassController, LuggageTypeController luggageTypeController, LuggageController luggageController) {
        this.ticketController = ticketController;
        this.boardingPassController = boardingPassController;
        this.luggageTypeController = luggageTypeController;
        this.luggageController = luggageController;
        ticketGrid = new TicketGrid(ticketController, boardingPassController, luggageTypeController, luggageController);
        ticketGrid.getElement().getStyle().set("background", "rgba(232, 234, 247, 1)");
        header = new HeaderStuff(button1, button2, "registration", "boardingControl");
        content.setPadding(false);
        content.setWidth("100%");
        content.add(main);
        content.setPadding(false);
        ticketGrid.getElement().getStyle().set("padding", "0px 90px");
        background.add(up, ticketGrid, bottom);
        background.setPadding(false);
        background.getElement().getStyle().set("padding-top", "90px")
                .set("padding-bottom", "70px");
        content.add(background);
        ticketGrid.getElement().getStyle().set("margin-top", "-10px");
        bottom.getElement().getStyle().set("margin-top", "0px");
        add(header, content, footer);
        this.setPadding(false);
    }
}
