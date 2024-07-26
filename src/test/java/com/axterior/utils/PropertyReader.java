package com.axterior.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties properties = new Properties();

    public static String readProperties(String key) {

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testrun.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
