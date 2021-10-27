package com.bad_java.lectures._14.library.infrastructure;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Model extends HashMap<String, Object> {

    public <T> T get(String key) {
        return this.<T>tryGet(key).orElseThrow(() -> new NoSuchElementException("No value present for key [" + key + "]"));
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> tryGet(String key) {
        return Optional.ofNullable((T) get((Object) key));
    }
}
