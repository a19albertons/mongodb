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
    private final MongoCollection<Document> collection = new MongoProvider().partidas(); // Si, soy consciente del
                                                                                         // resource leak

    /**
     * Crea una nueva partida en la base de datos.
     * 
     * @param partida documento con los datos de la partida a crear
     */
    public void crearPartida(String partida) {
        collection.insertOne(Document.parse(partida));
    }

    /**
     * Funcion que realiza una consulta avanzada
     * @param filtros Listado de bson que actuan como filtro
     * @return devuelve el resultado como un array de document de mongo db
     */
    public ArrayList<Document> consultador( List<Bson> filtros) {
        ArrayList<Document> resultado = new ArrayList<>();
        try {
            resultado =  collection.aggregate(filtros).into(new ArrayList<>());

        }
        catch(Exception e) {
            System.out.println("ha surgido una catastrofe en la consulta");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            resultado = new ArrayList<>();
        }
        
        return resultado;
    }
}
