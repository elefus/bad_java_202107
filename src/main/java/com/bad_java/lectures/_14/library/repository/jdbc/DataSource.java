package com.bad_java.lectures._14.library.repository.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequiredArgsConstructor
public class DataSource {

    private final String url;
    private final String user;
    private final String password;

    @SneakyThrows
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
