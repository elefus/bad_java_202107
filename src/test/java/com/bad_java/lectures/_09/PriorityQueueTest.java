package com.bad_java.lectures._09;

import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    @Test
    void name() {
        LJV ljv = new LJV().setTreatAsPrimitive(Integer.class);

        Queue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());


        values.add(3);
        values.add(5);
        values.add(4);
        values.add(0);
        browse(ljv, values);

        while (!values.isEmpty()) {
            System.out.println(values.poll());
        }
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
