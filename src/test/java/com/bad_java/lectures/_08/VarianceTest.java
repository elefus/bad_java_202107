package com.bad_java.lectures._08;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class VarianceTest {

    @Test
    void name() {
        // Совместимость присваивания
        String str = "123";
        Object obj = str;

        // Массивы - ковариантны
        String[] strings = {};
        Object[] objects = strings;

        // <? extends T> - ковариантен
        List<Integer> intList2 = null;
        List<? extends Number> numList2 = intList2;

        // Дженерики - инварианты
        CustomOptional<String> strOpt = null;
//        CustomOptional<Object> objOpt = strOpt;

        // <? super T> - контрвариантен
        List<Number> numList = null;
        List<? super Integer> intList = numList;
    }

    @Test
    void arrayCovarianceIssue() {
        String[] strings = {"1", "2"};

        Object[] objects = strings;

//        objects[0] = 1;
//        Integer[] ints = (Integer[]) objects;
    }

    @Test
    void genericsInvariance() {
        List<Object> objects = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("123");
        String s = strings.get(0);



        // objects = strings; error - invariance

        List<?> wildcard = strings;
        wildcard.add(null);
        Object o = wildcard.get(0);


        List<? extends Number> numbers1 = new ArrayList<Long>();
        numbers1.add(null);
        Number number = numbers1.get(0);


        ArrayList<Object> objects1 = new ArrayList<>();
        objects1.add("123");

        List<? super Number> numbers2 = objects1;
        Number num = 1;
        numbers2.add(num);
        numbers2.add(1);
        numbers2.add(0.4);
        numbers2.add(1L);
//        numbers2.add("123");

        Object object = numbers2.get(0);

        // Producer
        // Extends
        // Consumer
        // Super
    }

    @Test
    void comparatorsExample() {
        String[] strings = {"1", "22", "333", "4444"};

        Comparator<String> reverseComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        };
        Comparator<Object> hashCodeComparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };

        VarianceTest.<String>sort(strings, hashCodeComparator);

        List<String> list = List.of("1", "2");
        VarianceTest.test(list, hashCodeComparator);


        System.out.println(Arrays.toString(strings));
    }

    public static <T> void test(List<? extends T> list, Comparator<? super T> comparator) {
        list.sort(comparator);

    }

    public static <T> void sort(T[] arr, Comparator<? super T> comparator) {


    }

    private ArrayList<Number> getNumbers1() {
        return new ArrayList<Number>();
    }

    @Test
    void comparatorsTest() {
        List<Doctor> doctors = List.of(new Doctor(5, 180), new Doctor(3, 175));

        Comparator<Doctor> doctorComparator = new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return Integer.compare(o1.getExperience(), o2.getExperience());
            }
        };

        Comparator<Human> humanComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return Integer.compare(o1.getHeight(), o2.getHeight());
            }
        };
        sortWithT(doctors, doctorComparator);
        sortWithT(doctors, humanComparator);

    }

    public static <T> void sortWithT(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
    }
}

class A {

    public Number method() throws Exception {
        return null;
    }
}

class B extends A {

    // Список исключений ковариантен
    // Возвращаемые значения метода ковариантны
    @Override
    public Integer method() throws IOException {
        return null;
    }
}



@Getter
@AllArgsConstructor
class Human {

    private int height;
}

@Getter
class Doctor extends Human {

    private int experience;

    public Doctor(int experience, int height) {
        super(height);
        this.experience = experience;
    }
}
