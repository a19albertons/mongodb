package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.utils.MongoProviderSingleton;
import com.mongodb.client.MongoCollection;

/**
 * Controlador de empleados.
 */
public class PartidaController {
    private MongoProviderSingleton mongoProviderSingleton;

    
    /**
     * constructor del controlador de empleados
     * @param mongoProviderSingleton el mongo provider de tipo singleton para acceder a la base de datos
     */
    public PartidaController(MongoProviderSingleton mongoProviderSingleton) {
        this.mongoProviderSingleton = mongoProviderSingleton;
    }

    /**
     * Crea una nueva partida en la base de datos.
     * 
     * @param partida documento con los datos de la partida a crear
     */
    public void crearPartida(String partida) {
        try {
            MongoCollection<Document> collection = mongoProviderSingleton.partidas();
            collection.insertOne(Document.parse(partida));

        } catch (Exception e) {
            System.out.println("ha surgido una catastrofe en la insercion");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    /**
     * Funcion que realiza una consulta avanzada
     * 
     * @param filtros Listado de bson que actuan como filtro
     * @return devuelve el resultado como un array de document de mongo db
     */
    public ArrayList<Document> consultador(List<Bson> filtros) {
        ArrayList<Document> resultado = new ArrayList<>();
        try {
            MongoCollection<Document> collection = mongoProviderSingleton.partidas();
            resultado = collection.aggregate(filtros).into(new ArrayList<>());

        } catch (Exception e) {
            System.out.println("ha surgido una catastrofe en la consulta");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            resultado = new ArrayList<>();
        }

        return resultado;
    }
}
