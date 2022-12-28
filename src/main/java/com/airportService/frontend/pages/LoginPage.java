package com.airportService.frontend.pages;

import com.airportService.backend.controllers.AuthenticationController;
import com.airportService.backend.controllers.UserController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.airportService.backend.models.Role;

@Route("login")
public class LoginPage extends VerticalLayout {
    private final HorizontalLayout horizontalLayout = new HorizontalLayout();
    private final Image registrationAgentImage = new Image("images/reg-ag.png", "img1");
    private final Image securityOfficerImage = new Image("images/passport-control.png", "img2");
    private final Image managerImage = new Image("images/manager.png", "img2");
    private final Button registrationAgentButton = new Button("Registration & Boarding agent");
    private final Button managerButton = new Button("Airport manager");
    private final Button securityOfficerButton = new Button("Security officer");
    private final VerticalLayout registrationAgentLayout = new VerticalLayout();
    private final VerticalLayout managerLayout = new VerticalLayout();
    private final VerticalLayout securityOfficerLayout = new VerticalLayout();
    private PasswordField regField = new PasswordField();
    private Button regConfirmButton = new Button("Log in");
    private Button managerConfirmButton = new Button("Log in");
    private Button officerConfirmButton = new Button("Log in");
    private Button regCancelButton = new Button("Cancel");
    private Button managerCancelButton = new Button("Cancel");
    private Button officerCancelButton = new Button("Cancel");
    private final TextField managerField = new TextField("Password");
    private final TextField officerField = new TextField("Password");
    private final H1 heading = new H1("AIRPORT SERVICE STUFF");
    private final H5 text = new H5("Please, choose your role and log-in with the password provided by administration");
    private final VerticalLayout main = new VerticalLayout();
    private final HorizontalLayout toolbar = new HorizontalLayout();
    private final H5 dialogText = new H5("redirecting to page...");
    private final Button redirectButton = new Button("ok");
    private final Dialog dialog = new Dialog();
    private final Notification errorNotification
            = new Notification("Incorrect password!", 1500);

    @Autowired
    private final AuthenticationController authenticationController;
    @Autowired
    private final UserController userController;

    public LoginPage(AuthenticationController authenticationController, UserController userController) {
        dialog.add(dialogText, redirectButton);
        this.authenticationController = authenticationController;
        this.userController = userController;
        toolbar.setWidth("100%");
        regConfirmButton.setWidth("50%");
        managerConfirmButton.setWidth("50%");
        officerConfirmButton.setWidth("50%");
        regCancelButton.setWidth("50%");
        managerCancelButton.setWidth("50%");
        officerCancelButton.setWidth("50%");
        registrationAgentButton.setWidth("100%");
        regField.setPlaceholder("Password");
        regField.setWidth("100%");
        managerButton.setWidth("100%");
        securityOfficerButton.setWidth("100%");
        main.getElement().getStyle().set("padding", "100px 90px");
        registrationAgentLayout.add(registrationAgentImage, registrationAgentButton);
        registrationAgentLayout.getElement().getStyle().set("margin-top", "0");
        managerLayout.add(managerImage, managerButton);
        managerLayout.getElement().getStyle().set("margin-top", "9px");
        securityOfficerLayout.add(securityOfficerImage, securityOfficerButton);
        securityOfficerLayout.getElement().getStyle().set("margin-top", "4px");
        registrationAgentImage.setWidth("396px");
        registrationAgentImage.setHeight("157px");
        managerImage.setWidth("316px");
        managerImage.setHeight("151px");
        securityOfficerImage.setWidth("386px");
        securityOfficerImage.setHeight("157px");
        horizontalLayout.add(registrationAgentLayout, managerLayout, securityOfficerLayout);
        heading.getElement().getStyle().set("padding", "0 350px");
        text.getElement().getStyle().set("padding", "0 280px");
        main.add(heading, text, horizontalLayout);
        text.getElement().getStyle().set("margin-top", "0");
        text.getElement().getStyle().set("margin-bottom", "50px");
        registrationAgentButton.addClickListener(e -> login(e.getSource()));
        managerButton.addClickListener(e -> login(e.getSource()));
        securityOfficerButton.addClickListener(e -> login(e.getSource()));
        regCancelButton.addClickListener(e -> close(registrationAgentLayout));
        managerCancelButton.addClickListener(e -> close(managerLayout));
        officerCancelButton.addClickListener(e -> close(securityOfficerLayout));
        regConfirmButton.addClickListener(e -> redirect(Role.RegistrationAgent));
        managerConfirmButton.addClickListener(e -> redirect(Role.Manager));
        officerConfirmButton.addClickListener(e -> redirect(Role.SecurityOfficer));
        add(main);
    }

    public void login(Button button) {
        if(registrationAgentButton == button) {
            toolbar.removeAll();
            toolbar.add(regConfirmButton, regCancelButton);
            regField.clear();
            registrationAgentLayout.add(regField);
            registrationAgentLayout.add(toolbar);
        } else if(managerButton == button) {
            toolbar.removeAll();
            toolbar.add(managerConfirmButton, managerCancelButton);
            regField.clear();
            managerLayout.add(regField);
            managerLayout.add(toolbar);

        } else {
            toolbar.removeAll();
            toolbar.add(officerConfirmButton, officerCancelButton);
            regField.clear();
            securityOfficerLayout.add(regField);
            securityOfficerLayout.add(toolbar);
        }
    }

    public void redirect(Role role) {
        if (authenticationController.authentication(role, regField.getValue())) {
            if (role == Role.RegistrationAgent) {
                this.getUI().ifPresent(ui -> ui.navigate("registration"));
            } else if (role == Role.Manager) {
                this.getUI().ifPresent(ui -> ui.navigate("time"));
            } else {
                this.getUI().ifPresent(ui -> ui.navigate("passport"));
            }

        }
        else {
            errorNotification.open();
        }
    }

    public void close(VerticalLayout verticalLayout) {
        verticalLayout.remove(regField, toolbar);
    }
}
