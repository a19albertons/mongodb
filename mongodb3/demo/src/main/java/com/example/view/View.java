package com.example.view;

import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.example.controller.ControladorGeneral;
import com.example.model.Partida;
import com.google.gson.Gson;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Sorts;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.sort;

/**
 * Vista de la aplicación
 */
public class View {
    private ControladorGeneral controladorGeneral;

    /**
     * constructor de la vista
     * 
     * @param controladorGeneral controlador general de la aplicación
     */
    public View(ControladorGeneral controladorGeneral) {
        this.controladorGeneral = controladorGeneral;
    }

    /**
     * constructor de la vista
     */
    public void inicializar() {
        System.out.println("Vista inicializada");

        try (Scanner sc = new Scanner(System.in)) {
            // Añadir alguna partida para hacer pruebas posteriores

            // Partida partida = new Partida("jugador", "pong", 1000, 10, 5);
            // Partida partida2 = new Partida("Mario", "Space Invaders", 1200, 15, 3);
            // Partida partida3 = new Partida("Luigi", "Pac-Man", 800, 8, 2);
            // Partida partida4 = new Partida("Peach", "Donkey Kong", 1500, 20, 4);
            // Partida partida5 = new Partida("Bowser", "Galaga", 900, 12, 1);
            // Partida partida = new Partida("jugador", "pong", 2000, 60, 10);
            // Partida partida2 = new Partida("Mario", "Space Invaders", 200, 6, 8);
            // Partida partida3 = new Partida("Luigi", "Pac-Man", 1500, 4, 9);
            // Partida partida4 = new Partida("Peach", "Donkey Kong", 1400, 15, 1);
            // Partida partida5 = new Partida("Bowser", "Galaga", 9000, 40, 23);
            // controladorGeneral.getEmpleadoController().crearPartida(new
            // Gson().toJson(partida));
            // controladorGeneral.getEmpleadoController().crearPartida(new
            // Gson().toJson(partida2));
            // controladorGeneral.getEmpleadoController().crearPartida(new
            // Gson().toJson(partida3));
            // controladorGeneral.getEmpleadoController().crearPartida(new
            // Gson().toJson(partida4));
            // controladorGeneral.getEmpleadoController().crearPartida(new
            // Gson().toJson(partida5));

            // Consulta 1 - puntuacion total de cada jugador
            List<Bson> filtros1 = List.of(
                    group("$xogador", Accumulators.sum("puntuacionSumada", "$puntuacion")));
            System.out.println(controladorGeneral.getPartidaController().consultador(filtros1));

            // Consulta 2- mellor partida de cada xogador
            List<Bson> filtros2 = List.of(
                    group("$xogador", Accumulators.max("puntuacionMaxima", "$puntuacion")));
            System.out.println(controladorGeneral.getPartidaController().consultador(filtros2));
            // Consulta 3 - Partida máis curta por xogo
            List<Bson> filtros3 = List.of(
                    group("$xogo", Accumulators.min("menorDuracion", "$duracion")));
            System.out.println(controladorGeneral.getPartidaController().consultador(filtros3));

            // Consulta 4 - Ranking de xogadores por puntuación total acumulada y ordenado de maior a menor
            List<Bson> filtros4 = List.of(
                    group("$xogador", Accumulators.sum("puntuacionMaxima", "$puntuacion")),
                    sort(Sorts.descending("puntuacionMaxima"))

                );
            System.out.println(controladorGeneral.getPartidaController().consultador(filtros4));
        } catch (Exception e) {
            System.out.println("Fallo en la vista no esperado");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
