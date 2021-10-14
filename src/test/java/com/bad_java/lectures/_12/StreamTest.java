package com.bad_java.lectures._12;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    void name() {
        List<String> strings = List.of("a", "b", "c", "aa", "ccc");
        strings.stream()
               .filter(str -> str.length() < 3)
               .map(String::toUpperCase)
               .peek(str -> System.out.println("1# " + str))
               .sorted(Comparator.reverseOrder())
                .peek(str -> System.out.println("2# " + str))
               .limit(2)
               .forEach(System.out::println);

        Optional<Client> any = getClients()
                .stream()
                .filter(client -> client.getPerson().getAge() > 32)
                .filter(client -> client.getLicense().map(License::getExpirationDate).isPresent())
                .findAny();

        assertThat(any).isNotEmpty()
                       .map(Client::getPerson)
                       .map(Person::getName)
                       .get()
                       .isEqualTo("Ivan");

        IntFunction<String[]> stringArrayGenerator = size -> new String[size];
        String[] arr = stringArrayGenerator.apply(10);

        Map<String, Integer> stringLengths = strings.stream()
                                              .collect(toMap(identity(), String::length));


        // 1 2 3 4 5 6 7 8 9 0 sout
        // 1 2 3 4 5
        //           6 7 8 9 0
        //                     sout

    }


    public List<Client> getClients() {
        return List.of(
            new Client(
                    new Person("Ivan", "Ivanov", 35),
                    new License(
                            LocalDate.of(2020, 1, 1),
                            LocalDate.of(2023, 1, 1), "111-2323", new ArrayList<>(List.of(new Person("Ivan", "Ivanov", 35))))
            ),
            new Client(
                    new Person("Petr", "Petrov", 30),
                    new License(
                            LocalDate.of(2020, 1, 1),
                            LocalDate.of(2023, 1, 1), "111-2323", new ArrayList<>(List.of(new Person("Petr", "Petrov", 30))))
            )
        );
    }
}
