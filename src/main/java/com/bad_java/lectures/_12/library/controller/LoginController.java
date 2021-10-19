package com.bad_java.lectures._12.library.controller;

import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.exceptions.AuthenticationException;
import com.bad_java.lectures._12.library.infrastructure.Model;
import com.bad_java.lectures._12.library.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class LoginController implements Controller {

    private final UserService userService;

    @Override
    public String handle(Model inModel, Model outModel) {
        String username = inModel.get("username");
        String password = inModel.get("password");

        try {
            User authenticatedUser = userService.authenticate(username, password);
            outModel.put("user", authenticatedUser);
            switch (authenticatedUser.getType()) {
                case ADMIN:
                    return "admin_view";

                case CLIENT:
                    return "client_view";

                case MANAGER:
                    return "manager_view";
            }
        } catch (NoSuchElementException | AuthenticationException ex) {
            outModel.put("failedAuthentication", true);
        }
        return "login_view";
    }
}
