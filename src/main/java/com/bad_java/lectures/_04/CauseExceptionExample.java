package com.bad_java.lectures._04;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class CauseExceptionExample {

    public static void main(String[] args) {
        try {
            String name = getUsername();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUsername() {
        try {
            callDB();
        } catch (SQLException e) {
            NoSuchElementException ex = new NoSuchElementException();
            ex.initCause(e);
            throw ex;
        }
        return "user";
    }

    public static void callDB() throws SQLException {
        throw new SQLException();
    }
}
