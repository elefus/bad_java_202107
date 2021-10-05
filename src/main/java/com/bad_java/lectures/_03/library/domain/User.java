package com.bad_java.lectures._03.library.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    long id;
    String username;
    String password;
    Type type;

    public enum Type {
        ADMIN,
        MANAGER,
        CLIENT
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", type=" + type +
                '}';
    }
}
