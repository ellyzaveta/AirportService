package com.airportService.frontend.pages;

import com.airportService.backend.controllers.BoardingControlController;
import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.frontend.components.Footer;
import com.airportService.frontend.components.HeaderStuff;
import com.airportService.frontend.grids.BoardingControlGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Boarding control")
@Route("boardingControl")
public class BoardingControlPage extends VerticalLayout {
    @Autowired
    private final BoardingControlController boardingCheckController;
    @Autowired
    private final BoardingPassController boardingPassController;
    HeaderStuff header;
    Footer footer = new Footer();
    private final Button button1 = new Button("check-in");
    private final Button button2 = new Button("control");
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout main = new HorizontalLayout();
    BoardingControlGrid grid;
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image up = new Image("images/up4.png", "up");
    private final Image bottom = new Image("images/bottom4.png", "bottom");
    VerticalLayout background = new VerticalLayout();

    public BoardingControlPage(BoardingControlController boardingCheckController, BoardingPassController boardingPassController) {
        this.boardingCheckController = boardingCheckController;
        this.boardingPassController = boardingPassController;
        grid = new BoardingControlGrid(boardingCheckController, boardingPassController);
        grid.getElement().getStyle().set("background", "rgba(232, 234, 247, 1)");
        header = new HeaderStuff(button1, button2, "registration", "boardingControl");
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
