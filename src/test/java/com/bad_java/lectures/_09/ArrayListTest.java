package com.bad_java.lectures._09;

import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListTest {

    @Test
    void name() {
        LJV ljv = new LJV();

        ArrayList<String> list = new ArrayList<>(4);
        String str = "ab";
        str.hashCode();
        list.add(str);
        list.add("cd");
        list.add("cd");
        list.add("cd");
        list.add("ab");

        list.ensureCapacity(20);
        list.add(0, "vcx");


        list.remove(list.size() - 1);
        list.remove(0);

        list.indexOf("vcx");

        browse(ljv, list);
    }

    @Test
    void iterTest() {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);

        ListIterator<Integer> iter = ints.listIterator();
        //   1 2 3 4
        // ^

        assertThat(iter.nextIndex()).isEqualTo(0);
        assertThat(iter.next()).isEqualTo(1);
        //   1   2 3 4
        //     ^

        iter.set(10);

        //   10   2 3 4
        //      ^

        assertThat(ints.get(0)).isEqualTo(10);
        assertThat(iter.next()).isEqualTo(2);
        //   10 2   3 4
        //        ^

        assertThat(iter.next()).isEqualTo(3);
        //   10 2 3   4
        //          ^

        assertThat(iter.previous()).isEqualTo(3);
        //   10 2   3 4
        //        ^
        iter.remove();
        assertThat(ints).containsExactly(10, 2, 4);
        //   10 2   4
        //        ^
        assertThat(iter.next()).isEqualTo(4);
        assertThat(iter.nextIndex()).isEqualTo(3);
        assertThat(iter.hasNext()).isFalse();


        // Slow solution
        for (int i = 0; i < 500; i++) {
            ints.add(0, i);
        }

        int count = 500;
        ArrayList<Integer> toBeAdded = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            toBeAdded.add(i);
        }
        ints.addAll(0, toBeAdded);
    }

    @Test
    void concurrentModificationEx() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("bab");
        strings.add("dab");
        strings.add("bob");

        strings.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.startsWith("b");
            }
        });
    }

    public static void browse(LJV ljv, Object obj) {
        try {
            String str = ljv.drawGraph(obj);
            var dot = URLEncoder.encode(str, "UTF8").replaceAll("\\+", "%20");
            Desktop.getDesktop().browse(new URI("https://dreampuf.github.io/GraphvizOnline/#" + dot));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
