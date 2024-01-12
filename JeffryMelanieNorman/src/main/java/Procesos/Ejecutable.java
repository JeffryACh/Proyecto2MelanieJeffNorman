/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejecutable
 *
 * @author JeffryACh
 * 
 * Clase que representa un proceso de tipo Ejecutable
 */
public class Ejecutable extends Proceso{
    // Atributos
    private boolean esCooperativo;
    private String extencion;
    private final String[] EXTENCIONES = {"exe", "bat"};

    // Constructor
    /**
     * Constructor de la clase Ejecutable
     * @param esCooperativo - True si es cooperativo, false si no
     * @param extencion - Extencion del archivo
     * @param id - Identificador del proceso
     * @param nombre - Nombre del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public Ejecutable(boolean esCooperativo, String extencion, String recurso, int id, String nombre, int tiempo, int tamano, String fechaDeEjecucion, String horaDeEjecucion, String horaDefinalizacion) {
        super(id, nombre, tiempo, tamano, fechaDeEjecucion, horaDeEjecucion, horaDefinalizacion);
        this.esCooperativo = esCooperativo;
        this.extencion = extencion;
    }

    // Metodos
    // Getters y Setters
    /**
     * Metodo que retorna si el proceso es cooperativo o no
     * @return boolean - True si es cooperativo, false si no
     */
    public boolean isEsCooperativo() {
        return esCooperativo;
    }

    /**
     * Metodo que establece si el proceso es cooperativo o no
     * @param esCooperativo - True si es cooperativo, false si no
     */
    public void setEsCooperativo(boolean esCooperativo) {
        this.esCooperativo = esCooperativo;
    }

    /**
     * Metodo que retorna la extencion del archivo
     * @return String - Extencion del archivo
     */
    public String getExtencion() {
        return extencion;
    }

    /**
     * Metodo que establece la extencion del archivo
     * @param extencion - Extencion del archivo
     */
    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }
}
