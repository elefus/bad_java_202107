package com.bad_java.lectures._12;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCombination {

    // Arity
    // 0: () -> R
    // 1: (T1) -> R
    // 2: (T1, T2) -> R
    // 3: (T1, T2, T3) -> R
    // 4: (T1, T2, T3, T4) -> R

    // IO int
    // IO long
    // IO double
    //  O boolean
    //  O void

    /**
     * Arity 0
     * <p>
     * 1. Supplier: () -> R
     * 2. IntSupplier: () -> int
     * 3. LongSupplier: () -> long
     * 4. DoubleSupplier: () -> double
     * 5. BooleanSupplier: () -> boolean
     * -. Runnable: () -> void
     * <p>
     * <p>
     * Arity 1
     * <p>
     * 1. Consumer: (T) -> void
     * 2. IntConsumer: (int) -> void
     * 3. LongConsumer: (long) -> void
     * 4. DoubleConsumer: (double) -> void
     * <p>
     * <p>
     * Arity 1
     * <p>
     * 5. Predicate: (T) -> boolean
     * 6. IntPredicate: (int) -> boolean
     * 7. LongPredicate: (long) -> boolean
     * 8. DoublePredicate: (double) -> boolean
     * <p>
     * <p>
     * Arity 1
     * <p>
     * 9. UnaryOperator: (T) -> T
     * 10. IntUnaryOperator: (int) -> int
     * 11. LongUnaryOperator: (long) -> long
     * 12. DoubleUnaryOperator: (double) -> double
     * <p>
     * Arity 1
     * <p>
     * 13. Function: (T) -> R
     * 14. ToIntFunction: (T) -> int
     * 15. ToLongFunction: (T) -> long
     * 16. ToDoubleFunction: (T) -> double
     * 17. IntFunction: (int) -> R
     * 18. LongFunction: (long) -> R
     * 19. DoubleFunction: (double) -> R
     * 20. IntToLongFunction: (int) -> long
     * 21. IntToDoubleFunction: (int) -> double
     * 22. LongToIntFunction: (long) -> int
     * 23. LongToDoubleFunction: (long) -> double
     * 24. DoubleToIntFunction: (double) -> int
     * 25. DoubleToLongFunction: (double) -> long
     * <p>
     * <p>
     * Arity 2
     * <p>
     * 1. BiConsumer: (T, U) -> void
     * 2. ObjIntConsumer: (T, int) -> void
     * 3. ObjLongConsumer: (T, long) -> void
     * 4. ObjDoubleConsumer: (T, double) -> void
     * <p>
     * Arity 2
     * <p>
     * 5. BiPredicate: (T, U) -> boolean
     * <p>
     * Arity 2
     * 6. BinaryOperator: (T, T) -> T
     * 7. IntBinaryOperator: (int, int) -> int
     * 8. LongBinaryOperator: (long, long) -> long
     * 9. DoubleBinaryOperator: (double, double) -> double
     * <p>
     * Arity 2
     * <p>
     * 10. BiFunction: (T, U) -> R
     * 11. ToIntBiFunction: (T, U) -> int
     * 12. ToLongBiFunction: (T, U) -> long
     * 13. ToDoubleBiFunction: (T, U) -> double
     */

    @Test
    void name() {
        com.bad_java.lectures._12.data.Person ivan = new com.bad_java.lectures._12.data.Person("Ivan", "Ivanov");

        // Person -> Integer
        Function<com.bad_java.lectures._12.data.Person, Integer> personToNameLength = personStringPropertyToLength(com.bad_java.lectures._12.data.Person::getName, String::length);
        assertThat(personToNameLength.apply(ivan)).isEqualTo(4);

        Function<com.bad_java.lectures._12.data.Person, Integer> personToSurnameLength = personStringPropertyToLength(com.bad_java.lectures._12.data.Person::getSurname, String::length);
        assertThat(personToSurnameLength.apply(ivan)).isEqualTo(6);

        Function<com.bad_java.lectures._12.data.Person, Integer> getCountVowelsSurname = personStringPropertyToLength(com.bad_java.lectures._12.data.Person::getSurname, FunctionCombination::getCountVowelsJava8);
        assertThat(getCountVowelsSurname.apply(ivan)).isEqualTo(3);

        Function<com.bad_java.lectures._12.data.Person, Integer> getCountVowelsName = personStringPropertyToLength(com.bad_java.lectures._12.data.Person::getName, FunctionCombination::getCountVowelsJava8);
        assertThat(getCountVowelsName.apply(ivan)).isEqualTo(2);

        Function<com.bad_java.lectures._12.data.Person, String> extractor = com.bad_java.lectures._12.data.Person::getSurname;
        Function<com.bad_java.lectures._12.data.Person, Integer> getVowels = extractor.andThen(FunctionCombination::getCountVowelsJava8);
        Function<com.bad_java.lectures._12.data.Person, ?> print = getVowels.andThen(count -> { System.out.println(count); return null; } );

        print.apply(ivan);

        Function<String, com.bad_java.lectures._12.data.Person> createPersonWithName = name -> new com.bad_java.lectures._12.data.Person(name, "SURNAME");


        Function<String, String> composed = extractor.compose(createPersonWithName);
        String surname = composed.apply("Alex");
        System.out.println(surname);

        // currying - каррирование
        // partially applying - частичное применение
    }

    @Test
    void currying() {
        // (String,String,int) -> Person
        PersonFactory factory = com.bad_java.lectures._12.data.Person::new;

        // String -> (String -> (int -> Person))
        // String -> String -> int -> Person
        Function<String, Function<String, Function<Integer, com.bad_java.lectures._12.data.Person>>> curriedFactory =
                surname -> name -> age -> new com.bad_java.lectures._12.data.Person(name, surname, age);

        Function<String, Function<Integer, com.bad_java.lectures._12.data.Person>> plokhoyFactory = curriedFactory.apply("Plokhoy");
        Function<Integer, com.bad_java.lectures._12.data.Person> semenovFactory = plokhoyFactory.apply("Semenov");
    }

    @Test
    void predicates() {
        Predicate<com.bad_java.lectures._12.data.Person> greaterThan18 = p -> p.getAge() > 18;
        Predicate<com.bad_java.lectures._12.data.Person> isIvan = p -> "Ivan".equals(p.getName());

        assertThat(greaterThan18.test(new com.bad_java.lectures._12.data.Person("", "", 17))).isFalse();
        assertThat(greaterThan18.test(new com.bad_java.lectures._12.data.Person("", "", 19))).isTrue();

        Predicate<com.bad_java.lectures._12.data.Person> result = isIvan.and(greaterThan18);
        assertThat(result.test(new com.bad_java.lectures._12.data.Person("Ivan", "", 19))).isTrue();
        assertThat(result.test(new com.bad_java.lectures._12.data.Person("Alex", "", 19))).isFalse();
    }

    private static int getCountVowelsJava8(String str) {
        Set<Character> vowels = Set.of('a', 'u', 'e', 'i', 'o');
        return (int) str.chars()
                        .map(Character::toLowerCase)
                        .mapToObj(sym -> (char)sym)
                        .filter(vowels::contains)
                        .count();
    }

    private static int getCountVowelsOldStyle(String str) {
        Set<Character> vowels = Set.of('a', 'u', 'e', 'i', 'o');
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i))) {
                ++result;
            }
        }
        return result;
    }

    // ((Person -> String), (String -> Integer)) -> (Person -> Integer)
    private Function<com.bad_java.lectures._12.data.Person, Integer> personStringPropertyToLength(
            Function<com.bad_java.lectures._12.data.Person, String> propertyExtractor,
            Function<String, Integer> stringToInteger
    ) {
        return person -> {
            String property = propertyExtractor.apply(person);
            return stringToInteger.apply(property);
        };
    }
}
