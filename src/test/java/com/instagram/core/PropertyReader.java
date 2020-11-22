package com.instagram.core;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propInstance;

    private PropertyReader() {
    }

    /**
     * synchronized kullanımı staticten kaynaklı çakışmaları önlemek için kullanılıyor(yukarıda da volatile)
     * @return
     */

    public static synchronized PropertyReader getInstance() {

        if(propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * Method to return property value
     * @param propertyName
     * @return
     */

    public String getProperty(String propertyName) throws IOException {

        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(new File("config.properties"));

            prop.load(fileInputStream);

            if(prop.getProperty(propertyName) !=null){
                return prop.getProperty(propertyName);
            }

        return null;
    }
}