package com.bad_java.lectures._14.library.controller;

import com.bad_java.lectures._14.library.domain.Book;
import com.bad_java.lectures._14.library.domain.BookTicket;
import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.exceptions.BookInUseCannotBeDeletedException;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.service.LibraryService;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@RequiredArgsConstructor
public class ManagerController implements Controller {

    private final LibraryService libraryService;

    @Override
    public String handle(Model inModel, Model outModel) {
        User manager = inModel.get("user");
        String action = inModel.get("action");

        if ("logout".equals(action)) {
            return "login_view";
        }

        switch (action) {
            case "showBooks":
                Map<String, String> filters = inModel.get("filters");
                Predicate<Book> bookFilter = filters.entrySet()
                                                    .stream()
                                                    .map(entry -> getFilterForProperty(entry.getKey(), entry.getValue()))
                                                    .reduce($ -> true, Predicate::and);

                Map<Book, List<BookTicket>> booksWithTickets = libraryService.findBooksBy(bookFilter)
                                                                             .stream()
                                                                             .collect(toMap(identity(), libraryService::getBookTickets, ($,$$) -> null, LinkedHashMap::new));

                outModel.put("booksWithTickets", booksWithTickets);
                outModel.put("response", "showBooks");
                break;

            case "addBook":
                String isbn = inModel.get("isbn");
                String title = inModel.get("title");
                String author = inModel.get("author");
                int year = inModel.get("year");
                double price = inModel.get("price");
                int count = inModel.get("count");

                Book newBook = libraryService.addBook(manager, isbn, title, author, year, price, count);
                outModel.put("newBook", newBook);
                outModel.put("response", "addBook");
                break;

            case "deleteBook":
                Long bookId = inModel.get("bookId");
                try {
                    Book deletedBook = libraryService.delete(manager, bookId);
                    outModel.put("deletedBook", deletedBook);
                } catch (NoSuchElementException ex) {
                    outModel.put("error", "incorrect bookId");
                } catch (BookInUseCannotBeDeletedException ex) {
                    outModel.put("error", "cannot delete a book that currently used (" + ex.getNumberOfBooksInUse() + " copies currently in use.");
                }
                outModel.put("response", "deleteBook");
                break;
        }
        return "manager_view";
    }

    private Predicate<Book> getFilterForProperty(String propertyName, String expectedValue) {
        switch (propertyName) {
            case "isbn":
                return book -> book.getIsbn().equals(expectedValue);

            case "title":
                return book -> book.getTitle().equals(expectedValue);

            case "author":
                return book -> book.getAuthor().equals(expectedValue);

            case "year":
                return book -> book.getYear() == Integer.parseInt(expectedValue);

            default:
                throw new IllegalArgumentException("Unknown property name for book: " + propertyName);
        }
    }
}
