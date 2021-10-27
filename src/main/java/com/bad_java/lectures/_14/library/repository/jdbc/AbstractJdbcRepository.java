package com.bad_java.lectures._14.library.repository.jdbc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractJdbcRepository {

    protected final DataSource dataSource;
}
