package com.airportService.frontend.pages;

import com.airportService.backend.controllers.PassportControlController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.Header;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.grids.PassportControlGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Passport control")
@Route("passport")
public class PassportControlPage extends VerticalLayout {
    @Autowired
    private final PassportControlController passportControlController;
    HeaderStuff header;
    Footer footer = new Footer();
    private final Button button1 = new Button("passport");
    private final Button button2 = new Button("security");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    PassportControlGrid grid;
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up1.png", "up");
    private final Image bottom = new Image("images/bottom1.png", "bottom");
    VerticalLayout background = new VerticalLayout();

    public PassportControlPage(PassportControlController passportControlController) {
        this.passportControlController = passportControlController;
        grid = new PassportControlGrid(passportControlController);
        grid.getElement().getStyle().set("background", "rgba(218, 230, 255, 1)");
        header = new HeaderStuff(button1, button2, "passport", "security");
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
