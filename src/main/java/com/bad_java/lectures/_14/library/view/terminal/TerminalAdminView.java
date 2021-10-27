package com.bad_java.lectures._14.library.view.terminal;

import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.view.View;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class TerminalAdminView implements View {

    private static final String ADMIN_VIEW = "admin_view";
    private static final String ADMIN_CONTROLLER = "admin_controller";

    private final Terminal terminal;
    private final Map<String, Consumer<Model>> responseHandlers = Map.of(
            "showUsers", this::showUsers,
            "addUser", this::addUser,
            "deleteUser", this::deleteUser
    );

    private final Map<String, BiFunction<Model, String[], String>> commands = new LinkedHashMap<>(){{
        put("SHOW_USERS", TerminalAdminView.this::commandShowUsers);
        put("ADD_USER", TerminalAdminView.this::commandAddUser);
        put("DELETE_USER", TerminalAdminView.this::commandDeleteUser);
        put("LOGOUT", TerminalAdminView.this::commandLogout);
    }};

    @Override
    public String update(Model inModel, Model outModel) {
        User admin = inModel.get("user");

        inModel.<String>tryGet("response").ifPresentOrElse(handleResponse(inModel), () -> showFirstEntranceGreeting(admin));

        String target;
        do {
            String listOfCommands = commands.keySet().stream().collect(joining(", ", "[", "]"));
            terminal.println("#");
            terminal.println("# Please enter on of the command " + listOfCommands);
            terminal.print("> ");

            String[] parts = terminal.readLine().split(" ");
            String command = parts[0].toUpperCase();
            target = commands.getOrDefault(command, this::commandUnknown).apply(outModel, parts);
        } while (ADMIN_VIEW.equals(target));
        return target;
    }

    private String commandShowUsers(Model model, String...arguments) {
        model.put("action", "showUsers");
        return ADMIN_CONTROLLER;
    }

    private String commandAddUser(Model model, String...arguments) {
        model.put("username", arguments[1]);
        model.put("password", arguments[2]);
        model.put("type", arguments[3]);
        model.put("action", "addUser");
        return ADMIN_CONTROLLER;
    }

    private String commandDeleteUser(Model model, String...arguments) {
        model.put("userId", Long.parseLong(arguments[1]));
        model.put("action", "deleteUser");
        return ADMIN_CONTROLLER;
    }

    private String commandLogout(Model model, String...arguments) {
        terminal.println("#");
        terminal.println("# Closing admin mode...");
        terminal.println("############################");
        model.put("action", "logout");
        return ADMIN_CONTROLLER;
    }

    private String commandUnknown(Model model, String...arguments) {
        terminal.println("# Unknown command, please try again...");
        return ADMIN_VIEW;
    }

    private void showFirstEntranceGreeting(User admin) {
        terminal.println("############################");
        terminal.println("# Entered to the admin mode.");
        terminal.println("# Hello " + admin.getUsername() + "!");
    }

    private Consumer<String> handleResponse(Model inModel) {
        return response -> responseHandlers.get(response).accept(inModel);
    }

    private void showUsers(Model model) {
        terminal.println("# List of users:");
        model.<List<User>>get("users").stream().map(User::toString).map(string -> "# " + string).forEach(terminal::println);
    }

    private void addUser(Model model) {
        Optional<String> error = model.tryGet("error");
        if (error.isPresent()) {
            terminal.println("# Failed to add a new user!");
            terminal.println("# Error: " + error.get());
        } else {
            User newUser = model.get("newUser");
            terminal.println("# New user was added: " + newUser);
        }
    }

    private void deleteUser(Model model) {
        Optional<String> error = model.tryGet("error");
        if (error.isPresent()) {
            terminal.println("# Failed to delete a user!");
            terminal.println("# Error: " + error.get());
        } else {
            User newUser = model.get("deletedUser");
            terminal.println("# User was deleted: " + newUser);
        }
    }
}
