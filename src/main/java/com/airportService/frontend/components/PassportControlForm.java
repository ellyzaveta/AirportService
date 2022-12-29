package com.airportService.frontend.components;

import com.airportService.backend.controllers.PassportControlController;
import com.airportService.backend.models.PassportControl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PassportControlForm extends HorizontalLayout {
    private final PassportControlController passportControlController;
    private final PassportControl passportControl;
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

    public PassportControlForm(PassportControlController passportControlController, PassportControl passportControl) {
        this.passportControlController = passportControlController;
        this.passportControl = passportControl;

        firstName = new Label("First name: " + passportControl.getPassenger().getFirstName());
        lastName = new Label("Last name: " + passportControl.getPassenger().getLastName());
        passportNumber = new Label("Passport number: " + passportControl.getPassenger().getPassportNumber());
        form.add(firstName, lastName, passportNumber);

        cancel.addClickListener(e -> setVisible(false));
        save.addClickListener(e -> save());
        toolBar.add(save, cancel);

        verticalLayout.add(checkResult, comments, toolBar);
        verticalLayout.getElement().getStyle().set("margin-top", "5px");

        this.setWidth("50%");
        this.getElement().getStyle()
                .set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("background", "white")
                .set("margin-top", "30px");
        add(form, verticalLayout);
    }

    public void save() {
        if(!passportControl.isCheckResult()) {
            if (checkResult.getValue()) {
                passportControlController.updateToChecked(passportControl.getId());
                if (comments.getValue() != null) {
                    passportControlController.updateComments(passportControl.getId(), comments.getValue());
                }
            }
            else {
                if (comments.getValue() != null) {
                    passportControlController.updateComments(passportControl.getId(), comments.getValue());
                }
            }
            setVisible(false);
        }
    }
}
