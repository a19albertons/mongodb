package com.example.view;

import java.util.Scanner;

import org.bson.Document;

import com.example.controller.ControladorGeneral;
import com.example.model.Partida;
import com.google.gson.Gson;

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
            // controladorGeneral.getEmpleadoController().crearPartida(new Gson().toJson(partida));
            // controladorGeneral.getEmpleadoController().crearPartida(new Gson().toJson(partida2));
            // controladorGeneral.getEmpleadoController().crearPartida(new Gson().toJson(partida3));
            // controladorGeneral.getEmpleadoController().crearPartida(new Gson().toJson(partida4));
            // controladorGeneral.getEmpleadoController().crearPartida(new Gson().toJson(partida5));
            

        } catch (Exception e) {
            System.out.println("Fallo en la vista no esperado");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

}
