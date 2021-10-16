package com.bad_java.lectures._12;

import com.bad_java.lectures._03.library.domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@SuppressWarnings("ComparatorCombinators")
public class ComparatorTest {

    @Test
    void comparator() {
        // (Person,Person) -> int
        Comparator<com.bad_java.lectures._12.data.Person> firstNameComparator = (l, r) -> l.getName().compareTo(r.getName());
        Comparator<com.bad_java.lectures._12.data.Person> lastNameComparator = (l, r) -> l.getSurname().compareTo(r.getSurname());

        Comparator<com.bad_java.lectures._12.data.Person> nameComparator = getPersonComparator(com.bad_java.lectures._12.data.Person::getName);
        Comparator<com.bad_java.lectures._12.data.Person> surnameComparator = getPersonComparator(com.bad_java.lectures._12.data.Person::getSurname);

        Comparator<String> lengthComparator = getComparator(String::length);
        List<String> list = new ArrayList<>(List.of("1", "333", "22", ""));
        list.sort(lengthComparator);
        System.out.println(list);

        Comparator<String> hashComparator = getComparator(String::hashCode);

        Comparator<User> usernameComparator = getComparator(User::getUsername);
    }

    @Test
    void testByMultipleAttributes() {
        List<com.bad_java.lectures._12.data.Person> original = new ArrayList<>(Arrays.asList(
                null,
                new com.bad_java.lectures._12.data.Person("A", "f"),
                new com.bad_java.lectures._12.data.Person("A", "c"),
                new com.bad_java.lectures._12.data.Person("B", "a"),
                new com.bad_java.lectures._12.data.Person("A", "b"),
                new com.bad_java.lectures._12.data.Person("B", "c"),
                new com.bad_java.lectures._12.data.Person("C", "a")));

        List<com.bad_java.lectures._12.data.Person> bySurname = new ArrayList<>(original);
        bySurname.sort(Comparator.nullsLast(Comparator.comparing(com.bad_java.lectures._12.data.Person::getSurname).thenComparing(com.bad_java.lectures._12.data.Person::getName)));
        bySurname.forEach(System.out::println);

        System.out.println("=====");

        List<com.bad_java.lectures._12.data.Person> byName = new ArrayList<>(original);
        byName.sort(Comparator.nullsFirst(Comparator.comparing(com.bad_java.lectures._12.data.Person::getName)));
        byName.forEach(System.out::println);

//        list.sort(Comparator.comparing(Person::getName).thenComparing(Person::getSurname).thenComparing(Person::getAge));
    }

    // ((Person) -> String) -> ((Person,Person)-> int)
    public Comparator<com.bad_java.lectures._12.data.Person> getPersonComparator(Function<com.bad_java.lectures._12.data.Person, String> extractor) {
        return (person1, person2) -> extractor.apply(person1).compareTo(extractor.apply(person2));
    }

    public <T,R extends Comparable<? super R>> Comparator<T> getComparator(Function<T, R> extractor) {
        return (person1, person2) -> extractor.apply(person1).compareTo(extractor.apply(person2));
    }
}
