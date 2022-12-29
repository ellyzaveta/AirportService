package com.airportService.frontend.components;

import com.airportService.backend.controllers.SecurityControlController;
import com.airportService.backend.models.SecurityControl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class SecurityControlForm extends HorizontalLayout {
    private final SecurityControlController securityControlController;
    private final SecurityControl securityControl;
    private final Checkbox checkResult = new Checkbox("successful");
    private final TextField comments = new TextField("comments");
    private final Button save = new com.vaadin.flow.component.button.Button("Save");
    private final Button cancel = new Button("Cancel");
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final HorizontalLayout toolBar = new HorizontalLayout();
    private final Label firstName;
    private final Label lastName;
    private final Label passportNumber;
    private final VerticalLayout form = new VerticalLayout();

    public SecurityControlForm(SecurityControlController securityControlController, SecurityControl securityControl) {
        this.securityControlController = securityControlController;
        this.securityControl = securityControl;

        firstName = new Label("First name: " + securityControl.getPassenger().getFirstName());
        lastName = new Label("Last name: " + securityControl.getPassenger().getLastName());
        passportNumber = new Label("Passport number: " + securityControl.getPassenger().getPassportNumber());
        form.add(firstName, lastName, passportNumber);

        cancel.addClickListener(e -> setVisible(false));
        save.addClickListener(e -> save());
        toolBar.add(save, cancel);

        verticalLayout.add(checkResult, comments, toolBar);
        verticalLayout.getElement().getStyle().set("margin-top", "5px");

        this.setWidth("50%");
        this.getElement().getStyle().set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("background", "white");

        add(form, verticalLayout);
    }

    public void save() {
        if(!securityControl.isCheckResult()) {
            if (checkResult.getValue()) {
                securityControlController.updateToChecked(securityControl.getId());
                if (comments.getValue() != null) {
                    securityControlController.updateComments(securityControl.getId(), comments.getValue());
                }
            }
            else {
                if (comments.getValue() != null) {
                    securityControlController.updateComments(securityControl.getId(), comments.getValue());
                }
            }
            setVisible(false);
        }
    }
}
