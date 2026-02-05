package com.example.model;

/**
 * Modelo de partida.
 */
public class Partida {
    String xogador;
    String xogo;
    int puntuacion;
    int duracion;
    int nivel;

    /**
     * Devuelve el nombre del jugador.
     * 
     * @return nombre del jugador
     */
    public String getXogador() {
        return xogador;
    }

    /**
     * Establece el nombre del jugador.
     * 
     * @param xogador nombre del jugador
     */
    public void setXogador(String xogador) {
        this.xogador = xogador;
    }

    /**
     * Devuelve el nombre del juego.
     * 
     * @return nombre del juego
     */
    public String getXogo() {
        return xogo;
    }

    /**
     * Establece el nombre del juego.
     * 
     * @param xogo nombre del juego
     */
    public void setXogo(String xogo) {
        this.xogo = xogo;
    }

    /**
     * Devuelve la puntuacion obtenida en la partida.
     * 
     * @return puntuacion de la partida
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Establece la puntuacion obtenida en la partida.
     * 
     * @param puntuacion puntuacion de la partida
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Devuelve la duracion de la partida en segundos.
     * 
     * @return duracion de la partida en segundos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duracion de la partida en segundos.
     * 
     * @param duracion duracion de la partida en segundos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Devuelve el nivel alcanzado en la partida.
     * 
     * @return nivel alcanzado en la partida
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel alcanzado en la partida.
     * 
     * @param nivel nivel alcanzado en la partida
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Constructor completo para crear una partida con todos sus datos.
     * 
     * @param xogador    nombre del jugador
     * @param xogo       nombre del juego
     * @param puntuacion puntuacion obtenida en la partida
     * @param duracion   duracion de la partida en segundos
     * @param nivel      nivel alcanzado en la partida
     */
    public Partida(String xogador, String xogo, int puntuacion, int duracion, int nivel) {
        this.xogador = xogador;
        this.xogo = xogo;
        this.puntuacion = puntuacion;
        this.duracion = duracion;
        this.nivel = nivel;
    }

}
