package com.example.controller;

import org.bson.Document;

import com.example.utils.MongoProvider;
import com.mongodb.client.MongoCollection;

/**
 * Controlador de empleados.
 */
public class PartidaController {
    private final MongoCollection<Document> collection = new MongoProvider().partidas();

    /**
     * Crea una nueva partida en la base de datos.
     * 
     * @param partida documento con los datos de la partida a crear
     */
    public void crearPartida(String partida) {
        collection.insertOne(Document.parse(partida));
    }

    public void consultarPartidas(List<Bson> filtros)
}
