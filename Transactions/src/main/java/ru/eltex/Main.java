package ru.eltex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/testing";

        long time1 = System.currentTimeMillis();
        try {
            connection = DriverManager.getConnection(DB_URL, "user", "password");
            Statement statement = connection.createStatement();
            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO test1 VALUE(" + i + ", " + i + ")");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
        try {
            connection = DriverManager.getConnection(DB_URL, "user", "password");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            for (int i = 1000; i < 2000; i++) {
                statement.executeUpdate("INSERT INTO test1 VALUE(" + i + ", " + i + ")");
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        long time3 = System.currentTimeMillis();

        System.out.println("Добавление 1000 элементов без использования транзакций: " + (time2 - time1));
        System.out.println("Добавление 1000 элементов с использованием транзакций: " + (time3 - time2));
    }
}
