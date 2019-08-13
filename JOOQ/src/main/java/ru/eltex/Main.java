package ru.eltex;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.eltex.database.tables.Developerstable;
import ru.eltex.database.tables.records.DeveloperstableRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.getStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("db.host"),
                    properties.getProperty("db.login"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

        Result<DeveloperstableRecord> developers = context.selectFrom(Developerstable.DEVELOPERSTABLE).fetch();
        for (DeveloperstableRecord dev : developers) {
            System.out.println(dev.toString());
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\"_______\"");
    }
}
