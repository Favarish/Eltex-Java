package ru.eltex;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        properties.load(fis);


        MongoClient mongoClient = MongoClients.create(properties.getProperty("db.host"));
        MongoDatabase db = mongoClient.getDatabase(properties.getProperty("db.name"));
        MongoCollection<Document> table = db.getCollection(properties.getProperty("table"));

        table.deleteMany(new BasicDBObject());

        Document doc = new Document("name", "Rasty").append("phone", "9000").append("address", "Chesters-Mill");
        table.insertOne(doc);

        Document document = new Document("name", "Roza").append("address", "Chesters-Mill");
        table.insertOne(document);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("name", "Rose"));
        BasicDBObject searchQuery = new BasicDBObject().append("name", "Roza");
        table.updateOne(searchQuery, newDocument);


        for (Document cur : table.find()) {
            System.out.println(cur.toJson());
        }
    }
}
