package com.bad_java.lectures._14.library.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BookInUseCannotBeDeletedException extends RuntimeException {

    private final int numberOfBooksInUse;
}
