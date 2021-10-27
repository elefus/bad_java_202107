package com.bad_java.lectures._14.library;

import com.bad_java.lectures._14.library.controller.AdminController;
import com.bad_java.lectures._14.library.controller.LoginController;
import com.bad_java.lectures._14.library.infrastructure.Dispatcher;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.repository.jdbc.DataSource;
import com.bad_java.lectures._14.library.repository.jdbc.DataSourceFactory;
import com.bad_java.lectures._14.library.repository.jdbc.JdbcUserRepository;
import com.bad_java.lectures._14.library.service.UserService;
import com.bad_java.lectures._14.library.view.swing.SwingAdminView;
import com.bad_java.lectures._14.library.view.swing.SwingLoginView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SwingLauncher {

    public static void main(String[] args) throws IOException {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.create();
        JdbcUserRepository userRepository = new JdbcUserRepository(dataSource);

        UserService userService = new UserService(userRepository);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addController("login_controller", new LoginController(userService));
        dispatcher.addController("admin_controller", new AdminController(userService));

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Library ERP");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            dispatcher.addView("login_view", new SwingLoginView(frame, dispatcher));
            dispatcher.addView("admin_view", new SwingAdminView(frame, dispatcher));

            frame.setPreferredSize(new Dimension(800, 600));

            frame.pack();
            frame.setVisible(true);

            dispatcher.dispatchResponse("login_view", new Model());
        });
    }
}
