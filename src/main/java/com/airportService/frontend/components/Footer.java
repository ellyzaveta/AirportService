package com.airportService.frontend.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Footer extends HorizontalLayout {
    private final VerticalLayout footerVerticalLayout = new VerticalLayout();
    private final Paragraph p1 = new Paragraph("airport service");
    private final Paragraph p2 = new Paragraph("+38 (063) 12 34 567");
    private final Paragraph p3 = new Paragraph("airportService@gmail.com");
    private final Paragraph p4 = new Paragraph("© Khmyz & Balumatkina DA-01 IASA");
    private final Image image = new Image("images/clouds.png", "img");
    public Footer() {
        footerVerticalLayout.add(p1, p2, p3, p4);
        footerVerticalLayout.getElement().getStyle().set("margin-left", "110px");
        footerVerticalLayout.getElement().getStyle().set("margin-top", "70px");
        footerVerticalLayout.getElement().getStyle().set("text-align", "right");
        footerVerticalLayout.setPadding(false);
        footerVerticalLayout.setWidth("1180px");
        image.setWidth("1000px");
        this.setWidth("100%");
        this.setPadding(false);
        this.add(footerVerticalLayout, image);
        this.getElement().getStyle()
                .set("margin-top", "100px")
                .set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)");
    }
}
