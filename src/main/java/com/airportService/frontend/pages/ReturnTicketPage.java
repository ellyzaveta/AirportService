package com.airportService.frontend.pages;

import com.airportService.backend.controllers.TicketController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.components.ReturnForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Return ticket")
@Route("return")
public class ReturnTicketPage extends VerticalLayout {
    @Autowired
    private final TicketController ticketController;
    Header header;
    Footer footer = new Footer();
    private final Button buyButton = new Button("book ticket");
    private final Button returnButton = new Button("return ticket");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    Image image = new Image("images/return-tickets.png", "map");
    ReturnForm returnForm;

    public ReturnTicketPage(TicketController ticketController) {
        this.ticketController = ticketController;
        returnForm = new ReturnForm(this.ticketController);
        header = new Header(buyButton, returnButton, "main", "return");
        content.setPadding(false);
        content.setWidth("100%");
        content.add(main);
        content.setPadding(false);
        image.setWidth("750px");
        main.add(image, returnForm);
        content.add(main);
        content.getElement().getStyle().set("padding", "100px 150px");
        returnForm.getElement().getStyle().set("margin-left", "50px");

        add(header, content, footer);
        this.setPadding(false);
    }
}
