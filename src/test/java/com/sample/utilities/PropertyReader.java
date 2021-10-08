package com.sample.utilities;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    static Properties prop;
    static String value;

    public static String getProp(String propName) {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
            prop.load(fis);
            value = prop.getProperty(propName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void writeProp(String PropName, String value, String comment )
    {
        File configFile = new File("config.properties");

        try {
            Properties props = new Properties();
            props.setProperty(PropName, value);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, comment);
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file does not exist" + ex.getMessage());
        } catch (IOException ex) {
            // I/O error
        }
    }
}


