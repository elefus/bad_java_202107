package com.bad_java.lectures._10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourcesExample {

    private static final Logger log = LogManager.getLogger(ResourcesExample.class);

    public static void main(String[] args) {
        // URI - uniform resource identifier
        // URL - uniform resource locator

        log.info("213");

        URL url = ResourcesExample.class.getResource("/top_level_resource.txt");
        System.out.println(url);

        try (InputStream inputStream = ResourcesExample.class.getResourceAsStream("/top_level_resource.txt")) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties props = new Properties();
        try (InputStream in = ResourcesExample.class.getResourceAsStream("/config/application.properties")) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(props.getProperty("key").equals("value"));

        try (InputStream in = ResourcesExample.class.getResourceAsStream("package_file.txt")) {
            System.out.println(in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // . - current dir
        // .. - parent dir
    }
}
