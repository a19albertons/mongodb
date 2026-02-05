package com.example.controller;

import com.example.view.View;

/**
 * Controlador general de la aplicación
 */
public class ControladorGeneral {
    private PartidaController empleadoController;
    private View view;

    /**
     * getter controlador de empleados
     * 
     * @return devuelve el controlador de empleados
     */
    public PartidaController getEmpleadoController() {
        return empleadoController;
    }

    /**
     * constructor del Controlador general
     */
    public ControladorGeneral() {
        this.empleadoController = new PartidaController();
        this.view = new View(this);
    }

    /**
     * inicializa la vista
     */
    public void inicializar() {
        view.inicializar();
    }

}
