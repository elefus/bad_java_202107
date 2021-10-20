package com.bad_java.lectures._12.library;

import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.domain.BookTicket;
import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.exceptions.BookInUseCannotBeDeletedException;
import com.bad_java.lectures._12.library.repository.BookRepository;
import com.bad_java.lectures._12.library.repository.BookTicketRepository;
import com.bad_java.lectures._12.library.repository.UserRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryBookRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryBookTicketRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryUserRepository;
import com.bad_java.lectures._12.library.service.LibraryService;
import com.bad_java.lectures._12.library.service.UserService;
import com.bad_java.lectures._12.library.view.terminal.Terminal;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class OldLauncher {

    public static void main(String[] args) {
        System.out.println("Program started");

        Terminal terminal = new Terminal(System.in, System.out);
        UserRepository userRepository = new InMemoryUserRepository();
        prepareUserRepositoryMockData(userRepository);

        UserService userService = new UserService(userRepository);
        BookRepository bookRepository = new InMemoryBookRepository();
        prepareBookRepositoryMockData(bookRepository);

        BookTicketRepository bookTicketRepository = new InMemoryBookTicketRepository();
        LibraryService libraryService = new LibraryService(bookRepository, bookTicketRepository);

        do {
            User user = login(terminal, userService);
            switch (user.getType()) {
                case ADMIN:
                    handleAdmin(terminal, userService, user);
                    break;

                case MANAGER:
                    handleManager(terminal, libraryService, user);
                    break;

                case CLIENT:
                    handleClient(terminal, libraryService, user);
                    break;
            }
            terminal.print("Do you want to close program? Y/N: ");
        } while (!terminal.readLine().equalsIgnoreCase("y"));

        terminal.println("Program finished");
    }

    private static User login(Terminal terminal, UserService userService) {
        do {
            terminal.print("Please enter your username: ");
            String username = terminal.readLine();

            terminal.print("Please enter your password: ");
            String password = terminal.readLine();

            User authenticatedUser = userService.authenticate(username, password);
            if (authenticatedUser != null) {
                terminal.println("Hello " + authenticatedUser.getUsername() + "!");
                terminal.println("==========");
                return authenticatedUser;
            }
            terminal.println("Failed to login, please try again");
        } while (true);
    }

    private static void handleAdmin(Terminal terminal, UserService userService, User admin) {
        terminal.println("Entered to the admin mode...");

        do {
            terminal.print("Please enter the command: ");
            String[] parts = terminal.readLine().split(" ");
            String command = parts[0].toUpperCase();
            switch (command) {
                case "LIST_USERS":
                    terminal.println("List of users:");
                    for (Object user : userService.getUsers()) {
                        terminal.println(user.toString());
                    }
//                    userService.getUsers().forEach(new Consumer() {
//                        @Override
//                        public void accept(Object o) {
//                            terminal.println(o.toString());
//                        }
//                    });
                    break;

                case "ADD_USER": {
                    String username = parts[1];
                    String password = parts[2];
                    String type = parts[3];
                    User newUser = userService.add(admin, username, password, User.Type.valueOf(type));
                    terminal.println("New user was added: " + newUser);
                    break;
                }

                case "DELETE_USER": {
                    long userId = Long.parseLong(parts[1]);
                    User deletedUser = userService.delete(admin, userId);
                    if (deletedUser == null) {
                        terminal.println("You cannot delete yourself!");
                    } else {
                        terminal.println("User was deleted: " + deletedUser);
                    }
                    break;
                }

                case "EXIT":
                    terminal.println("Closing admin mode...");
                    return;

                default:
                    terminal.println("Unknown command, please try again...");
            }
        } while (true);
    }

    private static void handleManager(Terminal terminal, LibraryService libraryService, User manager) {
        terminal.println("Entered to the manager mode...");

        do {
            terminal.print("Please enter the command: ");
            String inputLine = terminal.readLine();
            String[] parts = inputLine.split(" ");
            String command = parts[0].toUpperCase();
            switch (command) {
                case "LIST_BOOKS": {
                    String isbn = null;
                    String title = null;
                    String author = null;
                    int year = -1;
                    if (parts.length > 1) {
                        String[] filters = inputLine.substring(command.length() + 1).split("&");
                        for (String filter : filters) {
                            String[] filterParts = filter.split("=");
                            String filterName = filterParts[0];
                            String filterValue = filterParts[1];
                            switch (filterName) {
                                case "isbn":
                                    isbn = filterValue;
                                    break;

                                case "title":
                                    title = filterValue;
                                    break;

                                case "author":
                                    author = filterValue;
                                    break;

                                case "year":
                                    year = Integer.parseInt(filterValue);
                                    break;
                            }
                        }
                    }
                    terminal.println("List of books: ");
                    for (Book book : libraryService.getBooks()) {
                        if (isbn != null && !book.getIsbn().equals(isbn)
                         || title != null && !book.getTitle().equals(title)
                         || author != null && !book.getAuthor().equals(author)
                         || year > 0 && book.getYear() != year) {
                            continue;
                        }
                        terminal.println(book.toString());

                        List<BookTicket> tickets = libraryService.getBookTickets(book);
                        if (!tickets.isEmpty()) {
                            terminal.println("\tThis book has been taken by: ");
                            for (BookTicket bookTicket : tickets) {
                                terminal.println("\t\t[" + bookTicket.getId() + "] " + bookTicket.getUser() + " at " + new Date(bookTicket.getTakenTimestamp()));
                            }
                        }
                    }
                    break;
                }

                case "ADD_BOOK": {
                    String isbn = parts[1];
                    String title = parts[2];
                    String author = parts[3];
                    int year = Integer.parseInt(parts[4]);
                    double price = Double.parseDouble(parts[5]);
                    int count = Integer.parseInt(parts[6]);
                    Book newBook = libraryService.addBook(manager, isbn, title, author, year, price, count);
                    terminal.println("New book was added: " + newBook);
                }

                case "DELETE_BOOK": {
                    long bookId = Long.parseLong(parts[1]);
                    try {
                        Book deletedBook = libraryService.delete(manager, bookId);
                        terminal.println("Book was deleted from library: " + deletedBook);
                    } catch (NoSuchElementException ex) {
                        terminal.println("Cannot find a book with provided ID: " + bookId);
                    } catch (BookInUseCannotBeDeletedException ex) {
                        terminal.println("Cannot delete a book that currently used! " + ex.getNumberOfBooksInUse() + " copies currently in use.");
                    }
                    break;
                }

                case "EXIT":
                    terminal.println("Closing manager mode...");
                    return;

                default:
                    terminal.println("Unknown command, please try again...");
            }
        } while (true);
    }

    private static void handleClient(Terminal terminal, LibraryService libraryService, User client) {
        terminal.println("Entered to the client mode...");

        do {
            terminal.print("Please enter the command: ");
            String inputLine = terminal.readLine();
            String[] parts = inputLine.split(" ");
            String command = parts[0].toUpperCase();
            switch (command) {
                case "LIST_BOOKS": {
                    String isbn = null;
                    String title = null;
                    String author = null;
                    int year = -1;
                    if (parts.length > 1) {
                        String[] filters = inputLine.substring(command.length() + 1).split("&");
                        for (String filter : filters) {
                            String[] filterParts = filter.split("=");
                            String filterName = filterParts[0];
                            String filterValue = filterParts[1];
                            switch (filterName) {
                                case "isbn":
                                    isbn = filterValue;
                                    break;

                                case "title":
                                    title = filterValue;
                                    break;

                                case "author":
                                    author = filterValue;
                                    break;

                                case "year":
                                    year = Integer.parseInt(filterValue);
                                    break;
                            }
                        }
                    }
                    terminal.println("List of books: ");
                    for (Book book : libraryService.getBooks()) {
                        if (isbn != null && !book.getIsbn().equals(isbn)
                                || title != null && !book.getTitle().equals(title)
                                || author != null && !book.getAuthor().equals(author)
                                || year > 0 && book.getYear() != year) {
                            continue;
                        }
                        terminal.println(book.toString());

                    }
                    break;
                }

                case "TAKE_BOOK": {
                    long bookId = Long.parseLong(parts[1]);
                    BookTicket ticket = libraryService.takeBook(client, bookId);
                    if (ticket != null) {
                        terminal.println("Book was taken from library: " + ticket);
                    } else {
                        terminal.println("Book was not taken from library: " + bookId);
                    }
                    break;
                }

                case "RETURN_BOOK": {
                    long ticketId = Long.parseLong(parts[1]);
                    Book returnedBook = libraryService.returnBook(client, ticketId);
                    if (returnedBook != null) {
                        terminal.println("Book was returned to the library: " + returnedBook);
                    } else {
                        terminal.println("Book was not returned to the library: ");
                    }
                    break;
                }

                case "EXIT":
                    terminal.println("Closing client mode...");
                    return;

                default:
                    terminal.println("Unknown command, please try again...");
            }
        } while (true);
    }

    private static void prepareUserRepositoryMockData(UserRepository userRepository) {
        userRepository.save(User.builder().username("admin").password("admin").type(User.Type.ADMIN).build());
        userRepository.save(User.builder().username("manager").password("manager").type(User.Type.MANAGER).build());
        userRepository.save(User.builder().username("client").password("client").type(User.Type.CLIENT).build());
    }

    private static void prepareBookRepositoryMockData(BookRepository bookRepository) {
        bookRepository.save(Book.builder().isbn("978-5-17-070645-7").title("Зов предков").author("Джек Лондон").year(1903).price(461.33).count(5).build());
        bookRepository.save(Book.builder().isbn("978-0-00-184912-9").title("Белый клык").author("Джек Лондон").year(1906).price(257.0).count(3).build());
        bookRepository.save(Book.builder().isbn("978-5-389-08245-8").title("Обломов").author("Иван Гончаров").year(2020).price(350.5).count(3).build());
        bookRepository.save(Book.builder().isbn("978-5-389-05507-0").title("Всадник без головы").author("Майн Рид").year(2020).price(520.7).count(3).build());
        bookRepository.save(Book.builder().isbn("978-5-389-18955-3").title("Гроза").author("Александр Островский").year(2019).price(325.6).count(5).build());
    }
}
