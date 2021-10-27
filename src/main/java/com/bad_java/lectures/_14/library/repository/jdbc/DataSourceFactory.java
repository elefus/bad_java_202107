package com.bad_java.lectures._14.library.repository.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceFactory {

    public DataSource create() throws IOException {
        Properties dbProps = new Properties();
        try (InputStream in = DataSourceFactory.class.getResourceAsStream("/db.properties")) {
            dbProps.load(in);
        }
        String url = dbProps.getProperty("url");
        String user = dbProps.getProperty("user");
        String password = dbProps.getProperty("password");
        return new DataSource(url, user, password);
    }
}
