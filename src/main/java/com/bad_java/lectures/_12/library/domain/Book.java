package com.bad_java.lectures._12.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class Book {

    long id;
    String isbn;
    String title;
    String author;
    int year;
    double price;
    int count;
}
