package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Developer extends User {
    @Getter @Setter
    private ArrayList<String> langs;

    public Developer(Integer id, String name, Short age, String phone) {
        super(id, name, age, phone);
        langs = new ArrayList<String>();
    }

    public Developer(Integer id, String name, Short age) {
        super(id, name, age);
        langs = new ArrayList<String>();
    }

    public void addRecord(Statement statement) throws SQLException {
        statement.executeUpdate("USE DBProject");
        if (this.existsDeveloper(statement)) {
            return;
        }

        statement.executeUpdate("INSERT INTO developersTable(id, name, age, phone) VALUE(" + this.getId() + ",'" +
                this.getName() + "'," + this.getAge() + "," + this.getPhone() + ")");
        if (this.langs.size() != 0) {
            for (String str : langs) {
                if (!existsLang(statement, str)) {
                    statement.executeUpdate("INSERT IGNORE INTO langsTable(langName) VALUE('" + str + "')");
                }
                ResultSet resultSet = statement.executeQuery("SELECT idLang FROM langsTable " +
                        "WHERE langName='" + str + "'");
                resultSet.next();
                int number = Integer.parseInt(resultSet.getString("idLang"));
                statement.executeUpdate("INSERT INTO joinDeveloperLangTable(idDeveloper, idLang) " +
                        "VALUE(" + this.getId() + "," + number + ")");
            }
        } else {
            System.out.println("Разработчик не знает языков!");
        }
    }

    private boolean existsLang(Statement statement, String str) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM langsTable WHERE langName='" + str + "'");

        if (resultSet.next()) {
            System.out.println("Такой язык уже есть (" + str + ")");
            return true;
        } else {
            System.out.println("Новый язык, добавляем! " + str);
            return false;
        }
    }

    private boolean existsDeveloper(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM developersTable WHERE " +
                "id=" + this.getId() + " AND name='" + this.getName() + "' AND age=" + this.getAge());

        if (resultSet.next()) {
            System.out.println(this.getName() + " я уже есть, меня записывать не нужно");
            return true;
        } else {
            System.out.println(this.getName() + " меня еще нет, надо записать!");
            return false;
        }
    }

    public void addLang(String... args) {
        for (String str : args) {
            langs.add(str);
        }
    }
}
