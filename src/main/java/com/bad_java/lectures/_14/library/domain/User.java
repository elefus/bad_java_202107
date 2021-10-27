package com.bad_java.lectures._14.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    long id;
    String username;
    String passwordHash;
    Type type;

    public enum Type {
        ADMIN,
        MANAGER,
        CLIENT
    }
}
