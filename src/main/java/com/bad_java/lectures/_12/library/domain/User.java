package com.bad_java.lectures._12.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    long id;
    String username;
    String password;
    Type type;

    public enum Type {
        ADMIN,
        MANAGER,
        CLIENT
    }
}
