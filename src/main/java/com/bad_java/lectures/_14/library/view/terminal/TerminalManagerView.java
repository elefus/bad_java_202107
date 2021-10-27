package com.bad_java.lectures._14.library.view.terminal;

import com.bad_java.lectures._14.library.domain.Book;
import com.bad_java.lectures._14.library.domain.BookTicket;
import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.view.View;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
public class TerminalManagerView implements View {

    private static final String MANAGER_VIEW = "manager_view";
    private static final String MANAGER_CONTROLLER = "manager_controller";

    private final Terminal terminal;
    private final Map<String, Consumer<Model>> responseHandlers = Map.of(
            "showBooks", this::showBooks,
            "addBook", this::addBook,
            "deleteBook", this::deleteBook
    );

    private final Map<String, BiFunction<Model, String[], String>> commands = new LinkedHashMap<>(){{
        put("SHOW_BOOKS", TerminalManagerView.this::commandShowBooks);
        put("ADD_BOOK", TerminalManagerView.this::commandAddBook);
        put("DELETE_BOOK", TerminalManagerView.this::commandDeleteBook);
        put("LOGOUT", TerminalManagerView.this::commandLogout);
    }};

    @Override
    public String update(Model inModel, Model outModel) {
        User manager = inModel.get("user");

        inModel.<String>tryGet("response").ifPresentOrElse(handleResponse(inModel), () -> showFirstEntranceGreeting(manager));

        String target;
        do {
            String listOfCommands = commands.keySet().stream().collect(joining(", ", "[", "]"));
            terminal.println("#");
            terminal.println("# Please enter on of the command " + listOfCommands);
            terminal.print("> ");

            String[] parts = terminal.readLine().split(" ");
            String command = parts[0].toUpperCase();
            target = commands.getOrDefault(command, this::commandUnknown).apply(outModel, parts);
        } while (MANAGER_VIEW.equals(target));
        return target;
    }

    private void showFirstEntranceGreeting(User admin) {
        terminal.println("############################");
        terminal.println("# Entered to the manager mode.");
        terminal.println("# Hello " + admin.getUsername() + "!");
    }

    private String commandShowBooks(Model model, String...arguments) {
        Map<String, String> filters = new HashMap<>();
        if (arguments.length > 1) {
            for (String filter : arguments[1].split("&")) {
                String[] filterParts = filter.split("=");
                String filterName = filterParts[0];
                String filterValue = filterParts[1];
                switch (filterName) {
                    case "isbn":
                        filters.put("isbn", filterValue);
                        break;

                    case "title":
                        filters.put("title", filterValue);
                        break;

                    case "author":
                        filters.put("author", filterValue);
                        break;

                    case "year":
                        filters.put("year", filterValue);
                        break;
                }
            }
        }
        model.put("filters", filters);
        model.put("action", "showBooks");
        return MANAGER_CONTROLLER;
    }

    private String commandAddBook(Model model, String...arguments) {
        model.put("isbn", arguments[1]);
        model.put("title", arguments[2]);
        model.put("author", arguments[3]);
        model.put("year", Integer.valueOf(arguments[4]));
        model.put("price", Double.valueOf(arguments[5]));
        model.put("count", Integer.valueOf(arguments[6]));
        model.put("action", "addBook");
        return MANAGER_CONTROLLER;
    }

    private String commandDeleteBook(Model model, String...arguments) {
        model.put("bookId", Long.parseLong(arguments[1]));
        model.put("action", "deleteBook");
        return MANAGER_CONTROLLER;
    }

    private String commandLogout(Model model, String...arguments) {
        terminal.println("#");
        terminal.println("# Closing manager mode...");
        terminal.println("############################");
        model.put("action", "logout");
        return MANAGER_CONTROLLER;
    }

    private String commandUnknown(Model model, String...arguments) {
        terminal.println("# Unknown command, please try again...");
        return MANAGER_VIEW;
    }

    private Consumer<String> handleResponse(Model inModel) {
        return response -> responseHandlers.get(response).accept(inModel);
    }

    private void showBooks(Model model) {
        Map<Book, List<BookTicket>> booksWithTickets = model.get("booksWithTickets");

        if (booksWithTickets.isEmpty()) {
            terminal.println("There are no books in library");
        } else {
            terminal.println("# List of books: ");
            booksWithTickets.forEach((book, tickets) -> {
                terminal.println("# " + book);
                if (!tickets.isEmpty()) {
                    terminal.println("\tThis book has been taken by: ");
                    for (BookTicket bookTicket : tickets) {
                        terminal.println("\t\t[" + bookTicket.getId() + "] " + bookTicket.getUser() + " at " + new Date(bookTicket.getTakenTimestamp()));
                    }
                }
            });
        }
    }

    private void addBook(Model model) {
        Optional<String> error = model.tryGet("error");
        if (error.isPresent()) {
            terminal.println("# Failed to add a new book!");
            terminal.println("# Error: " + error.get());
        } else {
            Book newBook = model.get("newBook");
            terminal.println("# New book was added: " + newBook);
        }
    }

    private void deleteBook(Model model) {
        Optional<String> error = model.tryGet("error");
        if (error.isPresent()) {
            terminal.println("# Failed to delete a book!");
            terminal.println("# Error: " + error.get());
        } else {
            Book newBook = model.get("deletedBook");
            terminal.println("# Book was deleted: " + newBook);
        }
    }
}
