package com.bad_java.lectures._12.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class BookTicket {

    private long id;
    private Book book;
    private User user;
    private long takenTimestamp;
}
