package com.bad_java.lectures._09;

import org.atpfivt.ljv.Direction;
import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    @Test
    void linked() {
        LJV ljv = new LJV().setDirection(Direction.LR).setTreatAsPrimitive(Integer.class);

        List<Integer> strings = new LinkedList<>();
        strings.add(1);
        strings.add(2);
        strings.add(3);

        browse(ljv, strings);
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
