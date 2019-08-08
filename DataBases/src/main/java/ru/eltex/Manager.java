package ru.eltex;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager extends User{
    @Getter @Setter
    ArrayList<Sale> sales;

    public Manager(Integer id, String name, Short age, String phone) {
        super(id, name, age, phone);
    }

    public void addRecord(Statement statement) throws SQLException {
        statement.executeUpdate("USE DBProject");
        if (this.existsManager(statement)) {
            return;
        }
        statement.executeUpdate("INSERT INTO managersTable(id, name, age, phone) VALUE(" + this.getId() + ",'" +
                this.getName() + "'," + this.getAge() + "," + this.getPhone() + ")");
    }

    private boolean existsManager(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM managersTable WHERE " +
                "id=" + this.getId() + " AND name='" + this.getName() + "' AND age=" + this.getAge());

        if (resultSet.next()) {
            System.out.println(this.getName() + " я уже есть, меня записывать не нужно");
            return true;
        } else {
            System.out.println(this.getName() + " меня еще нет, надо записать!");
            return false;
        }
    }
}
