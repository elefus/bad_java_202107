package com.bad_java.lectures._14.library.view.swing;

import com.bad_java.lectures._14.library.infrastructure.Dispatcher;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.infrastructure.ModelAndTarget;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class SwingLoginView extends AbstractSwingView {

    private static final String LOGIN_CONTROLLER = "login_controller";
    private final Container content = new Container();
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField userTextField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");

    public SwingLoginView(JFrame frame, Dispatcher dispatcher) {
        super(frame, dispatcher);

        resetButton.addActionListener(e -> resetFields());

        loginButton.addActionListener(e -> {
            Model model = new Model();
            model.put("username", userTextField.getText());
            model.put("password", passwordField.getPassword());

            ModelAndTarget response = dispatcher.dispatchRequest(LOGIN_CONTROLLER, model);
            SwingUtilities.invokeLater(() -> dispatcher.dispatchResponse(response.getTargetName(), response.getModel()));
        });
    }

    @Override
    public String update(Model inModel, Model outModel) {
        frame.getContentPane().removeAll();

        userLabel.setBounds(225, 170, 100, 30);
        passwordLabel.setBounds(225, 220, 100, 30);
        userTextField.setBounds(325, 170, 150, 30);
        passwordField.setBounds(325, 220, 150, 30);
        loginButton.setBounds(225, 280, 100, 30);
        resetButton.setBounds(375, 280, 100, 30);

        content.add(userLabel);
        content.add(passwordLabel);
        content.add(userTextField);
        content.add(passwordField);
        content.add(loginButton);
        content.add(resetButton);

        resetFields();

        frame.getContentPane().add(content);
        frame.repaint();

        Optional<Boolean> failedAuthentication = inModel.tryGet("failedAuthentication");
        if (failedAuthentication.orElse(false)) {
            JOptionPane.showMessageDialog(frame, "Failed to login, please try again.");
        }

        return LOGIN_CONTROLLER;
    }

    private void resetFields() {
        userTextField.setText("");
        passwordField.setText("");
    }
}
