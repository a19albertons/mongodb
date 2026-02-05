package com.example;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try (MongoProvider mongo = new MongoProvider()) {
            System.out.println("Conectado a MongoDB!");
            MongoCollection<Document> collection = mongo.alumnado();
            // Document alumno = new Document("nombre", "luis");
            // alumno.append("ciclo", "DAM");
            // alumno.append("edad", 50);
            // collection.insertOne(alumno);

            System.out.println(collection.deleteOne(Filters.eq("nombre", "juan")).getDeletedCount() + " usuarios eliminados.");

            collection.find().forEach(doc -> System.out.println(doc.toJson()));

        } catch (Exception e) {
            System.out.println("Ha surgido el siguiente error en tiempo de ejecucion:");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
