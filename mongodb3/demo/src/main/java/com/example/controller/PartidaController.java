package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.utils.MongoProvider;
import com.mongodb.client.MongoCollection;

/**
 * Controlador de empleados.
 */
public class PartidaController {
    private final MongoCollection<Document> collection = new MongoProvider().partidas(); // Si, soy consciente del resource leak

    /**
     * Crea una nueva partida en la base de datos.
     * 
     * @param partida documento con los datos de la partida a crear
     */
    public void crearPartida(String partida) {
        collection.insertOne(Document.parse(partida));
    }

    public ArrayList<Document> Consultador( List<Bson> filtros) {
        return collection.aggregate(filtros).into(new ArrayList<>());
    }
}
