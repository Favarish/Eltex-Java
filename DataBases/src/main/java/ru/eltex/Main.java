package ru.eltex;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    private static Connection connection = null;

    public static void main(String[] args) {
        String host = null;
        String login = null;
        String password = null;

        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");
            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        Developer dev1 = new Developer(1, "Barby", (short) 33, "987654321");
        dev1.addLang("C--", "Java", "Python");

        Developer dev2 = new Developer(2, "Renny", (short) 49, "555555555");

        Developer dev3 = new Developer(3, "Julia", (short) 40);
        dev3.addLang("Python", "C#", "C--");

        Manager manager1 = new Manager(1, "Sammy", (short) 30, "321321321");
        Manager manager2 = new Manager(2, "Joe", (short) 15, "2187462346");

        try {
            connection = DriverManager.getConnection(host, login, password);
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);

            createTables(statement);

            dev1.addRecord(statement);
            dev2.addRecord(statement);
            dev3.addRecord(statement);
            manager1.addRecord(statement);
            manager2.addRecord(statement);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM developersTable " +
                    "UNION " +
                    "SELECT * FROM managersTable");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("name") + " " +
                        resultSet.getString("age") + " " + resultSet.getString("phone"));
            }

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        System.out.println("I'm wording!");
    }


    public static void createTables(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS DBProject");
        statement.executeUpdate("USE DBProject");


        statement.executeUpdate("CREATE TABLE IF NOT EXISTS developersTable(" +
                "id INTEGER, " +
                "name TEXT, " +
                "age SMALLINT, " +
                "phone VARCHAR(11)," +

                "PRIMARY KEY (id))"
        );
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS joinDeveloperLangTable(" +
                "idDeveloper INTEGER NOT NULL," +
                "idLang INTEGER NOT NULL)"
        );
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS langsTable(" +
                "idLang INTEGER AUTO_INCREMENT, " +
                "langName TEXT NOT NULL," +
                "PRIMARY KEY (idLang))"
        );

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS managersTable(" +
                "id INTEGER, " +
                "name TEXT, " +
                "age SMALLINT, " +
                "phone VARCHAR(11), " +

                "PRIMARY KEY (id))"
        );
    }
}
