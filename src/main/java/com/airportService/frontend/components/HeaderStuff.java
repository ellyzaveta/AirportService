package com.airportService.frontend.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderStuff extends HorizontalLayout {
    private final Button logOut = new Button(VaadinIcon.SIGN_OUT.create());
    private final Icon icon = new Icon(VaadinIcon.AIRPLANE);
    private final H3 logoText = new H3("Airport Service");
    private final HorizontalLayout logo = new HorizontalLayout(icon, logoText);
    private final HorizontalLayout navigation = new HorizontalLayout();

    public HeaderStuff(Button button1, Button button2, String route1, String route2) {
        button1.addClickListener(e ->
                button1.getUI().ifPresent(ui ->
                        ui.navigate(route1))
        );
        button2.addClickListener(e ->
                button2.getUI().ifPresent(ui ->
                        ui.navigate(route2))
        );
        logOut.addClickListener(e ->
                logOut.getUI().ifPresent(ui ->
                        ui.navigate("login"))
        );

        icon.setSize("30px");
        logoText.getElement().getStyle().set( "margin-top" , "0");
        navigation.add(button1, button2, logOut);
        navigation.getElement().getStyle().set("margin-left", "805px");
        logo.getElement().getStyle().set("margin-top", "10px");

        this.setWidth("100%");
        this.getElement().getStyle()
                .set("box-shadow", "0px 4px 4px rgba(0, 0, 0, 0.2)")
                .set("padding" , "20px 90px");
        this.add(logo, navigation);
    }
}
