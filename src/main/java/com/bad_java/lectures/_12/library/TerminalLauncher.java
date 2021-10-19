package com.bad_java.lectures._12.library;

import com.bad_java.lectures._12.library.controller.AdminController;
import com.bad_java.lectures._12.library.controller.LoginController;
import com.bad_java.lectures._12.library.controller.ManagerController;
import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.infrastructure.Dispatcher;
import com.bad_java.lectures._12.library.infrastructure.Model;
import com.bad_java.lectures._12.library.infrastructure.ModelAndTarget;
import com.bad_java.lectures._12.library.repository.BookRepository;
import com.bad_java.lectures._12.library.repository.BookTicketRepository;
import com.bad_java.lectures._12.library.repository.UserRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryBookRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryBookTicketRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryUserRepository;
import com.bad_java.lectures._12.library.service.LibraryService;
import com.bad_java.lectures._12.library.service.UserService;
import com.bad_java.lectures._12.library.view.terminal.Terminal;
import com.bad_java.lectures._12.library.view.terminal.TerminalAdminView;
import com.bad_java.lectures._12.library.view.terminal.TerminalLoginView;
import com.bad_java.lectures._12.library.view.terminal.TerminalManagerView;

public class TerminalLauncher {

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        UserRepository userRepository = new InMemoryUserRepository();
        prepareUserRepositoryMockData(userRepository);
        UserService userService = new UserService(userRepository);

        BookTicketRepository bookTicketRepository = new InMemoryBookTicketRepository();
        BookRepository bookRepository = new InMemoryBookRepository();
        prepareBookRepositoryMockData(bookRepository);
        LibraryService libraryService = new LibraryService(bookRepository, bookTicketRepository);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addController("login_controller", new LoginController(userService));
        dispatcher.addController("admin_controller", new AdminController(userService));
        dispatcher.addController("manager_controller", new ManagerController(libraryService));
        dispatcher.addView("login_view", new TerminalLoginView(terminal));
        dispatcher.addView("admin_view", new TerminalAdminView(terminal));
        dispatcher.addView("manager_view", new TerminalManagerView(terminal));

        ModelAndTarget request = dispatcher.dispatchResponse("login_view", new Model());
        while (true) {
            ModelAndTarget response = dispatcher.dispatchRequest(request.getTargetName(), request.getModel());
            request = dispatcher.dispatchResponse(response.getTargetName(), response.getModel());
        }
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
