package com.example.controller;

import com.example.utils.MongoProviderSingleton;
import com.example.view.View;

/**
 * Controlador general de la aplicación
 */
public class ControladorGeneral {
    private PartidaController partidaController;
    private MongoProviderSingleton mongoProviderSingleton;
    private View view;

    /**
     * getter controlador de empleados
     * 
     * @return devuelve el controlador de empleados
     */
    public PartidaController getPartidaController() {
        return partidaController;
    }

    /**
     * constructor del Controlador general
     */
    public ControladorGeneral(MongoProviderSingleton mongoProviderSingleton) {
        this.mongoProviderSingleton = mongoProviderSingleton;
        this.partidaController = new PartidaController(this.mongoProviderSingleton);
        this.view = new View(this);
    }

    /**
     * inicializa la vista
     */
    public void inicializar() {
        view.inicializar();
    }

}
