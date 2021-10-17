package com.bad_java.lectures._12;

import com.bad_java.lectures._12.data.Employee;
import com.bad_java.lectures._12.data.EmployeeDataProvider;
import com.bad_java.lectures._12.data.JobHistoryEntry;
import com.bad_java.lectures._12.data.Person;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
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
                .filter(client -> client.getPerson()
                                        .getAge() > 32)
                .filter(client -> client.getLicense()
                                        .map(License::getExpirationDate)
                                        .isPresent())
                .findAny();

        assertThat(any).isNotEmpty()
                       .map(Client::getPerson)
                       .map(com.bad_java.lectures._12.data.Person::getName)
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
                        new com.bad_java.lectures._12.data.Person("Ivan", "Ivanov", 35),
                        new License(
                                LocalDate.of(2020, 1, 1),
                                LocalDate.of(2023, 1, 1), "111-2323", new ArrayList<>(List.of(new com.bad_java.lectures._12.data.Person("Ivan", "Ivanov", 35))))
                ),
                new Client(
                        new com.bad_java.lectures._12.data.Person("Petr", "Petrov", 30),
                        new License(
                                LocalDate.of(2020, 1, 1),
                                LocalDate.of(2023, 1, 1), "111-2323", new ArrayList<>(List.of(new com.bad_java.lectures._12.data.Person("Petr", "Petrov", 30))))
                )
        );
    }


    @Test
    void streams() throws IOException {
        Stream.of("asdsa", "asdasd", 23, 1, 545L);

        String[] strings = {"a", "b", "c"};
        Stream<String> streamOfStrings1 = Stream.of(strings);
        Stream<String> streamOfStrings2 = Arrays.stream(strings);

        File inputFile = File.createTempFile("bad_java_", "tmp");
        System.out.println(inputFile);
        inputFile.deleteOnExit();

        try (PrintWriter out = new PrintWriter(inputFile)) {
            // 0
            out.println("1");
            out.println("2");
            out.println("3");
            out.println("55");
            out.println("-5");
        }

        Path path = Paths.get(inputFile.getAbsolutePath());
        try (Stream<String> lines = Files.lines(path)) {
//            Integer result = lines.map(Integer::parseInt)
//                                  .reduce(0, Integer::sum);
            int result = lines.mapToInt(Integer::parseInt)
                              .sum();
            assertThat(result).isEqualTo(56);
        }

        byte[] data = {1, 2, 3, 4, '\n', 1, 2, '\n'};
        BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data)));
        Stream<String> lineStream = in.lines();
        assertThat(lineStream.count()).isEqualTo(2);

        Stream.Builder<Double> builder = Stream.builder();
        builder.add(1.0)
               .add(2.0)
               .add(3.0);
        Stream<Double> doubleStream = builder.build();

        // (Double,Double) -> int  // Double::compareTo
        // (double,double) -> int  // Double::compare

        DoubleStream doubleStream1 = doubleStream.mapToDouble(Double::doubleValue);
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream1.summaryStatistics();

        assertThat(doubleSummaryStatistics.getMin()).isCloseTo(1.0, Offset.offset(0.00001));
        assertThat(doubleSummaryStatistics.getMax()).isCloseTo(3.0, Offset.offset(0.00001));

        Integer mult = Stream.of(1, 2, 3, 4, 2, 1, 0, -1, 3)
                             .filter(val -> val > 2)
//                               .reduce(1, (a, b) -> a * b);
                             .reduce(1, Math::multiplyExact);
        // (((1 * 3) * 4) * 3)
        assertThat(mult).isEqualTo(36);

        Supplier<String> supplier = () -> "HELLO";
        Stream<String> generatedStream = Stream.generate(supplier);

        Supplier<Integer> randomIntGenerator = () -> ThreadLocalRandom.current()
                                                                      .nextInt();
        Stream<Integer> randomIntStream = Stream.generate(randomIntGenerator);
        Integer[] randomValues = randomIntStream.limit(5)
                                                .toArray(Integer[]::new);

        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        System.out.println(joiner.add("a")
                                 .add("b")
                                 .add("c"));

        // IntStream -> Stream<String>
        String result = ThreadLocalRandom.current()
                                         .ints(10, 0, 100)
                                         .mapToObj(String::valueOf)
                                         .collect(joining(", ", "{", "}"));
        System.out.println(result);

        Stream.iterate(1, val -> val < 10, val -> val + 2)
              .forEach(System.out::println);

        Stream<Object> emptyStream1 = Stream.of();
        Stream<Object> emptyStream2 = Stream.empty();

        String source = "a:b:c";
        Stream<String> stringStream = Pattern.compile(":")
                                             .splitAsStream(source);
        List<String> tokens = stringStream.collect(toCollection(LinkedList::new));
        assertThat(tokens).containsExactly("a", "b", "c");

        Stream<Integer> left = Stream.of(3, 2, 1);
        Stream<Integer> right = Stream.of(3, 5, 4);

        assertThat(Stream.concat(left, right)
                         .distinct()
                         .sorted()).containsExactly(1, 2, 3, 4, 5);

        assertThat(IntStream.rangeClosed(0, 10)
                            .max()
                            .orElseThrow()).isEqualTo(10);
    }

    @Test
    void primitiveStreams() {
        int[] arr = {2, 3, 0};
        OptionalInt max = IntStream.of(arr)
                                   .max();
        OptionalInt min = IntStream.of(arr)
                                   .min();
        OptionalDouble average = IntStream.of(arr)
                                          .average();

        IntSummaryStatistics statistics = IntStream.of(arr)
                                                   .summaryStatistics();
        assertThat(statistics.getCount()).isEqualTo(3);
        assertThat(statistics.getAverage()).isCloseTo(1.666, Offset.offset(0.001));
        assertThat(statistics.getMin()).isEqualTo(0);
        assertThat(statistics.getMax()).isEqualTo(3);
        assertThat(statistics.getSum()).isEqualTo(5);


        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        intSummaryStatistics.accept(2);
        intSummaryStatistics.accept(3);
        intSummaryStatistics.accept(0);
        assertThat(intSummaryStatistics.getCount()).isEqualTo(3);
        assertThat(intSummaryStatistics.getAverage()).isCloseTo(1.666, Offset.offset(0.001));
        assertThat(intSummaryStatistics.getMin()).isEqualTo(0);
        assertThat(intSummaryStatistics.getMax()).isEqualTo(3);
        assertThat(intSummaryStatistics.getSum()).isEqualTo(5);
    }

    @Test
    void drugExample() {
        Integer result = Stream.of(1, 2, 3, 4)
                               .skip(1)
                               .reduce(0, Integer::sum);
    }

    @Test
    void tasks() {
        EmployeeDataProvider provider = new EmployeeDataProvider();

        List<Employee> employees = provider.getEmployees();

        // Найти всех людей, у кого больше двух мест работы в записной книжке
        List<Person> result1 = employees.stream()
                                        .filter(employee -> employee.getJobHistory()
                                                                    .size() > 2)
                                        .map(Employee::getPerson)
                                        .collect(toList());

        // Вывести на экран фамилии Иванов
        employees.stream()
                 .map(Employee::getPerson)
                 .filter(person -> "Иван".equals(person.getName()))
                 .map(Person::getSurname)
                 .forEach(System.out::println);

        // Найти людей, старше 25 лет с dev-опытом
        List<Person> result2 = employees.stream()
                                     .filter(employee -> employee.getPerson().getAge() > 25)
                                     .filter(var -> var.getJobHistory()
                                                       .stream()
                                                       .map(JobHistoryEntry::getPosition)
                                                       .anyMatch("dev"::equals))
                                     .map(Employee::getPerson)
                                     .collect(toList());

        // Вывести полные имена 3 сотрудников с наибольшим стажем
        String result3 = employees.stream()
                                  .sorted(getReversed())
                                  .limit(3)
                                  .map(Employee::getPerson)
                                  .map(person -> person.getSurname() + " " + person.getName())
                                  .collect(joining("; "));

        // Сгруппировать людей по фамилиям
//        Map<String, Employee>

        Map<String, List<Employee>> result4 = employees.stream()
                                                       .collect(groupingBy(employee -> employee.getPerson().getSurname()));

        // Количество людей с определенной фамилией
        Map<String, Long> result5 = employees.stream()
                                   .collect(groupingBy(employee -> employee.getPerson().getSurname(), counting()));

        // Разделить на тех, кто старше 18 и младше
        Map<Boolean, Long> result6 = employees.stream()
                                    .collect(partitioningBy(employee -> employee.getPerson().getAge() > 18, counting()));
        System.out.println(result6);
    }

    private Comparator<Employee> getReversed() {
        return Comparator.<Employee>comparingInt(employee -> employee.getJobHistory()
                                                                      .stream()
                                                                      .mapToInt(JobHistoryEntry::getDuration)
                                                                      .sum())
                          .reversed();
    }
}
