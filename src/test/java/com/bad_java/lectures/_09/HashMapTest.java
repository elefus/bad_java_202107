package com.bad_java.lectures._09;

import org.atpfivt.ljv.LJV;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

    Map<Integer, String> oldWayBeforeJava9 = new HashMap<>() {{
        put(1, "1");
        put(2, "1");
        put(3, "1");
    }};

    @Test
    void java9way() {
        Map<Integer, String> map = Map.of(1, "1", 2, "2");
        Map<Integer, String> bigMap = Map.ofEntries(
                Map.entry(1, "1"),
                Map.entry(2, "2"),
                Map.entry(3, "3"),
                // ...
                Map.entry(11, "11")
        );
    }

    @Test
    void name() {
        LJV ljv = new LJV().setTreatAsPrimitive(Integer.class).setTreatAsPrimitive(String.class);
        String str1 = "Aa";
        String str2 = "BB";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1.equals(str2));

        Map<String, Object> map = new LinkedHashMap<>(4);
        map.put(str1, 1);


        map.put(str2, 1);
        map.put("gg", 2);
        map.put("uyt", 3);
        map.put("bb", 3);
        map.put("hhh", 3);
        map.put("oioio", 3);

//        browse(ljv, map);

        System.out.println(map);
    }

    @Test
    void collisions() {
        LJV ljv = new LJV().setTreatAsPrimitive(Integer.class).setTreatAsPrimitive(String.class);

        Map<Object, Object> map = new HashMap<>(64);

        Object key1 = createConstantHashObject();
        map.put(key1, 1);
        map.put(createConstantHashObject(), 1);

        Object key2 = createConstantHashObject();
        map.put(key2, 1);

        map.put(createConstantHashObject(), 1);
        map.put(createConstantHashObject(), 1);
        map.put(createConstantHashObject(), 1);
        map.put(createConstantHashObject(), 1);
        map.put(createConstantHashObject(), 1);
        map.put(createConstantHashObject(), 1);

        assertThat(key1.hashCode()).isEqualTo(key2.hashCode()).isEqualTo(2);
        assertThat(System.identityHashCode(key1)).isNotEqualTo(System.identityHashCode(key2));
        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));

        browse(ljv, map);
    }

    @Test
    void name2() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("AB", 1);
        map.put(map, 2);
        map.put(map, 3);
        System.out.println(map);
    }

    private static Object createConstantHashObject() {
        return new Object() {
            @Override
            public int hashCode() {
                return 2;
            }
        };
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
