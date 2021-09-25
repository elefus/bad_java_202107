package com.bad_java.lectures._09;

import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayDequeTest {

    @Test
    void test() {
        LJV ljv = new LJV().setTreatAsPrimitive(Integer.class);

        Deque<Integer> values = new ArrayDeque<>();
        values.push(10);
        values.push(20);

        assertThat(values.pop()).isEqualTo(20);

        values.addLast(15);
        values.addLast(25);
        values.addLast(35);

        values.removeFirst();
        values.removeFirst();

        browse(ljv, values);
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
