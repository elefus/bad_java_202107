package com.bad_java.lectures._12.data;

import lombok.Value;

@Value
public class Person {

    String name;
    String surname;
    int age;

    // (String,String,int) -> Person
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // (String,String) -> Person
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
    }
}