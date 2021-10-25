package com.bad_java.lectures._12.data;

import java.util.List;

public class EmployeeDataProvider {

    public List<Employee> getEmployees() {
        return List.of(
                new Employee(
                        new Person("Иван", "Мельников", 30),
                        List.of(
                                new JobHistoryEntry(2, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Александр", "Дементьев", 28),
                        List.of(
                                new JobHistoryEntry(1, "qa", "EPAM"),
                                new JobHistoryEntry(6, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Дмитрий", "Осинов", 40),
                        List.of(
                                new JobHistoryEntry(3, "qa", "yandex"),
                                new JobHistoryEntry(1, "qa", "mail.ru"),
                                new JobHistoryEntry(1, "dev", "mail.ru")
                        )),
                new Employee(
                        new Person("Анна", "Светличная", 21),
                        List.of(
                                new JobHistoryEntry(1, "qa", "T-Systems")
                        )),
                new Employee(
                        new Person("Игорь", "Толмачёв", 50),
                        List.of(
                                new JobHistoryEntry(5, "qa", "EPAM"),
                                new JobHistoryEntry(6, "analyst", "EPAM")
                        )),
                new Employee(
                        new Person("Иван", "Александров", 16),
                        List.of(
                                new JobHistoryEntry(2, "qa", "T-Systems"),
                                new JobHistoryEntry(3, "qa", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM")
                        )),
                new Employee(
                        new Person("Семен", "Александров", 33),
                        List.of(
                                new JobHistoryEntry(2, "qa", "T-Systems"),
                                new JobHistoryEntry(3, "qa", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM")
                        ))
        );

    }
}
