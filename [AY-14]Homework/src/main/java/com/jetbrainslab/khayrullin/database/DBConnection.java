package com.jetbrainslab.khayrullin.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class DBConnection {

    static Connection conn;

    static {
        final String DRIVER = "org.postgresql.Driver";
        String url = null;
        String username = null;
        String password = null;

        // read db pruseoperties
        try (InputStream in = DBConnection.class
                .getClassLoader().getResourceAsStream("database.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            exit(ex, "Failed to load properties!");
        }

        // acquire db connection
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            exit(ex, "Failed to get connection to the db!");
        } catch (ClassNotFoundException e) {
            exit(e, "Driver trouble");
        }
    }

    private static void exit(Exception e, String msg) {
        System.out.println(msg);
        e.printStackTrace();
        System.exit(1);
    }
}
