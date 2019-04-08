package com.checklisttarasgl.classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    static final String db_username = "userlogin";
    static final String db_password = "useruser123";
    static final String url = "jdbc:sqlserver://DESKTOP-HNAFTUU\\SQLEXPRESS;databaseName=Checklist";

    static {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException ex) {
            System.err.println("Can't find class 'com.microsoft.sqlserver.jdbc.SQLServerDriver'");
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
            throw new RuntimeException("Can't find class 'com.microsoft.sqlserver.jdbc.SQLServerDriver'");
        }


    }



    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException ex) {
            System.err.println("Can't find class 'com.microsoft.sqlserver.jdbc.SQLServerDriver'");
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
            throw new RuntimeException("Can't find class 'com.microsoft.sqlserver.jdbc.SQLServerDriver'");
        }
        try {
            Connection connection = DriverManager.getConnection(url,
                    db_username, db_password);
            System.out.println("connected");

            return connection;

        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
