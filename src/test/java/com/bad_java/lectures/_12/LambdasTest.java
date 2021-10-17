package com.bad_java.lectures._12;

import com.bad_java.lectures._12.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdasTest {

    @Test
    void name() {
        // SAM - single abstract method
        // Function descriptor - SAM-interface (args) -> returnValue {throws list}
        // FunctionalInterface

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        // (Integer, Integer) -> Integer

        Summator<Integer> anonSym = new Summator<Integer>() {
            @Override
            public Integer sum(Integer a, Integer b) {
                return a + b;
            }
        };
        assertThat(anonSym.sum(1, 2)).isEqualTo(3);

        // Full-body statement lambda
        // (Integer, Integer) -> Integer       (Integer, Integer) -> String
        Summator<Integer> sum = (Integer left, Integer right) -> {
            return left + right;
        };

        BiFunction<Integer, Integer, String> fun = (Integer left, Integer right) -> {
            return "left + right";
        };

        // Statement lambda
        Summator<Integer> sum2 = (l, r) -> {
            return l + r;
        };

        // Expression lambda
        Summator<Integer> sum3 = (l, r) -> l + r;
        Integer result = sum3.sum(1, 2);
        assertThat(result).isEqualTo(3);

        Consumer<String> printer = string -> System.out.println(string);
        printer.accept("hello from lambda");

        // () -> void
        Runnable sayHello = () -> System.out.println("Hello from runnable!");
        sayHello.run();
    }

    @Test
    void staticMethodReferences() {
//        Summator<String> strSummator = (left, right) -> LambdasTest.stringSum(left, right);
        Summator<String> strSummator = LambdasTest::stringSum;
        assertThat(strSummator.sum("a", "b")).isEqualTo("ab");
        assertThat(strSummator.sum("b", "b")).isEqualTo("bb");
        assertThat(strSummator.sum("c", "b")).isEqualTo("cb");
    }

    // (String,String) -> String
    private static String stringSum(String left, String right) {
        return left + right;
    }

    private String delimiter = ".";

    private String stringSumWithDelimiter(String left, String right) {
        return left + delimiter + right;
    }

    @Test
    void instanceMethodReference() {
        assertThat(this.stringSumWithDelimiter("a", "b")).isEqualTo("a.b");

        LambdasTest test = new LambdasTest();
        test.delimiter = "~";
        assertThat(test.stringSumWithDelimiter("a", "b")).isEqualTo("a~b");

        Summator<String> thisSummator = this::stringSumWithDelimiter;
        assertThat(thisSummator.sum("a", "b")).isEqualTo("a.b");

        Summator<String> testSummator = test::stringSumWithDelimiter;
        assertThat(testSummator.sum("a", "b")).isEqualTo("a~b");

        Summator<String> onNewInstanceSummator = new LambdasTest()::stringSumWithDelimiter;
        assertThat(onNewInstanceSummator.sum("a", "b")).isEqualTo("a.b");

        Summator<String> onNewInstance2Summator = createTest("--")::stringSumWithDelimiter;
        assertThat(onNewInstance2Summator.sum("a", "b")).isEqualTo("a--b");
    }

    @Test
    void typeMethodReference() {
        String str = "hello";

        Function<String, Integer> getLength1 = s -> s.length();
        Function<String, Integer> getLength2 = s -> LambdasTest.getLength(s);
        Function<String, Integer> getLength3 = LambdasTest::getLength;
        Function<String, Integer> getLength4 = String::length;

        assertThat(getLength1.apply("1234")).isEqualTo(4);
        assertThat(getLength4.apply("123")).isEqualTo(3);
    }

    @Test
    void typeInference() {

        ToIntFunction<String> getLength = String::length;
        Consumer<String> consumer = String::length;

    }

    @Test
    void constructorReference() {
        com.bad_java.lectures._12.data.Person person = new com.bad_java.lectures._12.data.Person("Ivan", "Ivanov", 44);

        PersonFactory factory1 = new PersonFactory() {
            @Override
            public com.bad_java.lectures._12.data.Person create(String name, String surname, int age) {
                return new com.bad_java.lectures._12.data.Person(name, surname, age);
            }
        };

        // (String,String,int) -> Person
        PersonFactory factory2 = (name, surname, age) -> new com.bad_java.lectures._12.data.Person(name, surname, age);
        PersonFactory factory3 = com.bad_java.lectures._12.data.Person::new;
        com.bad_java.lectures._12.data.Person another = factory3.create("Ivan", "Ivanov", 44);
        assertThat(person).isEqualTo(another);

        // (String,String) -> Person
        BiFunction<String, String, com.bad_java.lectures._12.data.Person> factory4 = com.bad_java.lectures._12.data.Person::new;
        com.bad_java.lectures._12.data.Person zero = factory4.apply("Ivan", "Ivanov");
        assertThat(zero.getAge()).isZero();
    }

    // String -> int
    public static int getLength(String str) {
        return str.length();
    }

    private static LambdasTest createTest(String delimiter) {
        LambdasTest test = new LambdasTest();
        test.delimiter = delimiter;
        return test;
    }

    @Test
    void closureExample() {

        int val2 = 0;

        Runnable oldVersion = new Runnable() {

            @Override
            public void run() {
                System.out.println(val2);
            }
        };


        Runnable task = () -> {
            int val;
            val = 10;

            val++;
            System.out.println(val);
        };
    }

    @Test
    void mutableLambda() {
//        AtomicInteger counter = new AtomicInteger();

        int[] counter = new int[1];

        ((Runnable)() -> {
            for (int i = 0; i < 10; i++) {
                counter[0]++;
            }
        }).run();

        int result = counter[0];


    }
}


interface PersonFactory {

    // (String,String,int) -> Person
    Person create(String name, String surname, int age);
}

@FunctionalInterface
interface Summator<T> {

    T sum(T a, T b);

    default int another() {
        return 0;
    }

    static void method() {}
}
