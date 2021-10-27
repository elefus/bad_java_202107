package com.bad_java.lectures._14.library.exceptions;

import java.sql.SQLException;

public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(SQLException ex) {
        super(ex);
    }
}