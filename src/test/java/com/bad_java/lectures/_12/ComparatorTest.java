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
        Comparator<Person> firstNameComparator = (l, r) -> l.getName().compareTo(r.getName());
        Comparator<Person> lastNameComparator = (l, r) -> l.getSurname().compareTo(r.getSurname());

        Comparator<Person> nameComparator = getPersonComparator(Person::getName);
        Comparator<Person> surnameComparator = getPersonComparator(Person::getSurname);

        Comparator<String> lengthComparator = getComparator(String::length);
        List<String> list = new ArrayList<>(List.of("1", "333", "22", ""));
        list.sort(lengthComparator);
        System.out.println(list);

        Comparator<String> hashComparator = getComparator(String::hashCode);

        Comparator<User> usernameComparator = getComparator(User::getUsername);
    }

    @Test
    void testByMultipleAttributes() {
        List<Person> original = new ArrayList<>(Arrays.asList(
                null,
                new Person("A", "f"),
                new Person("A", "c"),
                new Person("B", "a"),
                new Person("A", "b"),
                new Person("B", "c"),
                new Person("C", "a")));

        List<Person> bySurname = new ArrayList<>(original);
        bySurname.sort(Comparator.nullsLast(Comparator.comparing(Person::getSurname).thenComparing(Person::getName)));
        bySurname.forEach(System.out::println);

        System.out.println("=====");

        List<Person> byName = new ArrayList<>(original);
        byName.sort(Comparator.nullsFirst(Comparator.comparing(Person::getName)));
        byName.forEach(System.out::println);

//        list.sort(Comparator.comparing(Person::getName).thenComparing(Person::getSurname).thenComparing(Person::getAge));
    }

    // ((Person) -> String) -> ((Person,Person)-> int)
    public Comparator<Person> getPersonComparator(Function<Person, String> extractor) {
        return (person1, person2) -> extractor.apply(person1).compareTo(extractor.apply(person2));
    }

    public <T,R extends Comparable<? super R>> Comparator<T> getComparator(Function<T, R> extractor) {
        return (person1, person2) -> extractor.apply(person1).compareTo(extractor.apply(person2));
    }
}
