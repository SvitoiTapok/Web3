package com.example.lab3.util;

import java.sql.*;
public class DBConnector {
    public static final String DATABASE_HELIOS_URL = "jdbc:postgresql://pg/studs";
    public static Statement statmt;
    public static Connection connection;
    public static void connect(){
        try {
            connection = DriverManager.getConnection(DATABASE_HELIOS_URL);
            System.out.println("Успешное подключение к базе данных PostgreSQL!");
            statmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
}
