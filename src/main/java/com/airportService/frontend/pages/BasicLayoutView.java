package com.airportService.frontend.pages;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.WidgetTicket;
import com.airportService.frontend.components.WidgetTime;
import com.airportService.frontend.grids.FlightList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Ticket booking")
@Route("main")
public class BasicLayoutView extends VerticalLayout implements RouterLayout, PageConfigurator  {
    @Autowired
    private final MainFlightController mainFlightController;
    Image image = new Image("images/wow.png", "map");
    VerticalLayout text = new VerticalLayout();
    H1 welcome = new H1("LET'S EXPLORE THE WORLD");
    H4 text2 = new H4("Book aviatickets online with your best search preferences");
    HorizontalLayout main = new HorizontalLayout();
    WidgetTime widgetTime;
    WidgetTicket widgetTicket;
    FlightList flightList;
    HorizontalLayout layout = new HorizontalLayout();
    VerticalLayout widget1 = new VerticalLayout();
    VerticalLayout widget2 = new VerticalLayout();
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout center = new HorizontalLayout();
    Header header;
    Footer footer = new Footer();
    private final Button buyButton = new Button("book ticket");
    private final Button returnButton = new Button("return ticket");
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up.png", "up");
    private final Image bottom = new Image("images/bottom.png", "bottom");

    public BasicLayoutView(MainFlightController mainFlightController) {
        header = new Header(buyButton, returnButton, "main", "return");
        up.getElement().getStyle().set("margin-bottom", "-10px");
        bottom.getElement().getStyle().set("margin-top", "0");
        layout.getElement().getStyle().set("margin-top", "0");
        this.mainFlightController = mainFlightController;
        this.widgetTime = new WidgetTime(mainFlightController);
        this.widgetTicket = new WidgetTicket(mainFlightController);
        this.flightList = new FlightList(this.mainFlightController);
        image.setWidth("850px");
        text2.getElement().getStyle().set("margin-top", "0");
        welcome.getElement().getStyle().set("margin-top", "0");
        text.add(welcome, text2);
        text.getElement().getStyle().set("margin-top", "170px");
        widgetTime.setWidth("500px");
        widgetTime.setHeight("300px");
        widgetTicket.setHeight("300px");
        widgetTicket.setWidth("750px");
        main.getElement().getStyle().set("margin-top", "60px");
        main.add(image, text);
        widget1.setPadding(false);
        widget1.setWidth("500px");
        widget2.setWidth("750px");
        widget2.setPadding(false);
        widgetTime.setPadding(false);
        widget1.add(widgetTime);
        widget2.add(widgetTicket);
        layout.getElement().getStyle().set("padding", "5px 90px");
        layout.setWidth("100%");
        layout.getElement().getStyle().set("background", "rgba(236, 243, 249, 1)");
        layout.add(widget1, widget2);
        verticalLayout.add(up, layout, bottom);
        verticalLayout.setPadding(false);
        content.setPadding(false);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        center.setWidth("100%");
        content.setWidth("100%");
        main.getElement().getStyle().set("padding-left", "90px");
        main.getElement().getStyle().set("padding-right", "90px");
        main.getElement().getStyle().set("padding-bottom", "70px");
        main.getElement().getStyle().set("padding-top", "30px");
        layout.setWidth("100%");
        flightList.getElement().getStyle().set("padding-left", "90px");
        flightList.getElement().getStyle().set("padding-right", "90px");
        content.add(main, verticalLayout, flightList);
        add(header, content, footer);
    }

    @Override
    public void configurePage(InitialPageSettings settings) {
        settings.addFavIcon("icon", "images/plane-icon.png", "20x20");
    }
}
