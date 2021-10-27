package com.bad_java.lectures._14.library.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModelAndTarget {

    private final Model model;
    private final String targetName;
}
