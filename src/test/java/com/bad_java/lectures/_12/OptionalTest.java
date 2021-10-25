package com.bad_java.lectures._12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

    @Test
    void name() {
        Optional<Client> optionalClient = getClientByName("Ivan", "Ivanov"); // non-empty

        // map = T -> R
        // flatMap = T > Optional<R>
        // Client -> Optional<License>
        Optional<License> license = optionalClient.flatMap(Client::getLicense);

        System.out.println(optionalClient.filter(client -> client.getPerson().getAge() > 40) // empty
                                         .flatMap(Client::getLicense) // empty
                                         .map(License::getId)     // empty
                                         .orElse("NOT_FOUND"));




    }

    private static Optional<Client> getClientByName(String name, String surname) {
        if ("Ivan".equals(name) && "Ivanov".equals(surname)) {
            com.bad_java.lectures._12.data.Person ivan = new com.bad_java.lectures._12.data.Person("Ivan", "Ivanov", 35);
            License license = new License(
                    LocalDate.of(2020, 1, 1),
                    LocalDate.of(2023, 1, 1), "111-2323", new ArrayList<>(List.of(ivan)));
            return Optional.of(new Client(ivan, license));
        }
        if ("Petr".equals(name) && "Petrov".equals(surname)) {
            com.bad_java.lectures._12.data.Person ivan = new com.bad_java.lectures._12.data.Person("Petr", "Petrov", 30);
            return Optional.of(new Client(ivan, null));
        }
        return Optional.empty();
    }
}

@Getter
@AllArgsConstructor
class Client {

    com.bad_java.lectures._12.data.Person person;
    License license;

    public Optional<License> getLicense() {
        return Optional.ofNullable(license);
    }
}

@Getter
@AllArgsConstructor
class License {

    LocalDate registrationDate;
    LocalDate expirationDate;
    String id;
    List<com.bad_java.lectures._12.data.Person> issuers;
}

