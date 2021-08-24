package com.bad_java.lectures._03.library;

import com.bad_java.lectures._03.DynamicArray;
import com.bad_java.lectures._03.library.domain.Book;
import com.bad_java.lectures._03.library.domain.BookTicket;
import com.bad_java.lectures._03.library.domain.User;
import com.bad_java.lectures._03.library.repository.BookRepository;
import com.bad_java.lectures._03.library.repository.BookTicketRepository;
import com.bad_java.lectures._03.library.repository.memory.InMemoryBookRepository;
import com.bad_java.lectures._03.library.repository.memory.InMemoryBookTicketRepository;
import com.bad_java.lectures._03.library.repository.memory.InMemoryUserRepository;
import com.bad_java.lectures._03.library.repository.UserRepository;
import com.bad_java.lectures._03.library.service.LibraryService;
import com.bad_java.lectures._03.library.service.UserService;

import java.util.Date;
import java.util.function.Consumer;

public class Launcher {

    public static void main(String[] args) {
        System.err.println("Program started");

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

        System.err.println("Program finished");
    }

    private static User login(Terminal terminal, UserService userService) {
        do {
            terminal.print("Please enter your username: ");
            String username = terminal.readLine();

            terminal.print("Please enter your password: ");
            String password = terminal.readLine();

            User user = userService.authenticate(username, password);
            if (user != null) {
                terminal.println("Hello " + username + "!");
                return user;
            }

            terminal.println("Failed to login, please try again!");
        } while (true);
    }

    private static void handleAdmin(Terminal terminal, UserService userService, User admin) {
        terminal.println("Entered to the admin mode...");

        do {
            terminal.print("Please enter the command: ");
            String[] parts = terminal.readLine().split(" ");
            String command = parts[0].toUpperCase();
            switch (command) {
                case "GET_USERS":
                    terminal.println("List of users:");
                    userService.getUsers().forEach(new Consumer() {
                        @Override
                        public void accept(Object o) {
                            terminal.println(o);
                        }
                    });
                    break;

                case "ADD_USER":
                    String username = parts[1];
                    String password = parts[2];
                    String type = parts[3];
                    User newUser = userService.add(admin, username, password, User.Type.valueOf(type));
                    terminal.println("New user was added: " + newUser);
                    break;

                case "DELETE_USER":
                    long userId = Long.parseLong(parts[1]);
                    User deletedUser = userService.delete(admin, userId);
                    if (deletedUser == null) {
                        terminal.println("Failed to delete user with id: " + userId);
                    } else {
                        terminal.println("User was deleted: " + deletedUser);
                    }
                    break;

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
                // GET_BOOKS => all books
                // GET_BOOKS title=asd asdsa&year=2020&isbn=12312
                case "GET_BOOKS": {
                    String isbn = null;
                    String title = null;
                    String author = null;
                    Integer year = null;
                    if (parts.length > 1) {
                        String[] filters = inputLine.substring(command.length() + 1)
                                                    .split("&");
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
                                    year = Integer.valueOf(filterValue);
                                    break;
                            }
                        }
                    }
                    terminal.println("List of books: ");
                    for (Object bookObj : libraryService.getBooks()) {
                        Book book = (Book) bookObj;
                        if (isbn != null && !book.getIsbn().equals(isbn)
                         || title != null && !book.getTitle().equals(title)
                         || author != null && !book.getAuthor().equals(author)
                         || year != null && book.getYear() != year
                        ) {
                            continue;
                        }
                        terminal.println(book);

                        DynamicArray tickets = libraryService.getBookTickets(book);
                        if (!tickets.isEmpty()) {
                            terminal.println("\tThis book has been taken by: ");
                            for (Object bookTicketObj : tickets) {
                                BookTicket bookTicket = (BookTicket) bookTicketObj;
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
                    if (newBook != null) {
                        terminal.println("New book was added: " + newBook);
                    } else {
                        terminal.println("New book was not added because of duplication ISBN: " + isbn);
                    }
                    break;
                }

                case "DELETE_BOOK": {
                    long bookId = Long.parseLong(parts[1]);
                    Book deletedBook = libraryService.delete(manager, bookId);
                    if (deletedBook != null) {
                        terminal.println("Book was deleted from library: " + deletedBook);
                    } else {
                        terminal.println("Book was not deleted from library: " + bookId);
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
                case "GET_BOOKS": {
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
                    for (Object bookObj : libraryService.getBooks()) {
                        Book book = (Book) bookObj;
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
                        terminal.println("Book was not returned to the library: " + ticketId);
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
