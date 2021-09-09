package com.bad_java.lectures._03;

import lombok.*;

public class LombokExample {

    public static void main(String[] args) {
        val address = new Address("Poltavskaya 15", "Saint-Petersburg", "197345");
        System.out.println(address);

        val person = new Person(1, "elefus", "Nikolai", "Plokhoi", address);

        Person person2 = Person.builder()
                .id(1)
                .username("elefus")
                .name("Nikolai")
                .surname("Plokhoi")
                .address(address)
                .build();

        System.out.println(person.getId());
    }
}

@Value
@Builder
class Person {

    long id;
    String username;
    String name;
    String surname;
    Address address;
}

// P - plain
// O - old
// J - java
// O - object

// D - Data
// T - Transfer
// O - Object
@Value
class Address {

    String address;
    String city;
    String zipCode;
}
