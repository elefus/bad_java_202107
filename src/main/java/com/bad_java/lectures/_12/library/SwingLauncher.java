package com.bad_java.lectures._12.library;

import com.bad_java.lectures._12.library.controller.AdminController;
import com.bad_java.lectures._12.library.controller.LoginController;
import com.bad_java.lectures._12.library.domain.Book;
import com.bad_java.lectures._12.library.domain.User;
import com.bad_java.lectures._12.library.infrastructure.Dispatcher;
import com.bad_java.lectures._12.library.infrastructure.Model;
import com.bad_java.lectures._12.library.repository.BookRepository;
import com.bad_java.lectures._12.library.repository.UserRepository;
import com.bad_java.lectures._12.library.repository.memory.InMemoryUserRepository;
import com.bad_java.lectures._12.library.service.UserService;
import com.bad_java.lectures._12.library.view.swing.SwingAdminView;
import com.bad_java.lectures._12.library.view.swing.SwingLoginView;

import javax.swing.*;
import java.awt.*;

public class SwingLauncher {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        prepareUserRepositoryMockData(userRepository);
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
