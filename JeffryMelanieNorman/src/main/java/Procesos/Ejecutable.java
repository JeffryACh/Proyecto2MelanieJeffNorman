/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un proceso de tipo Ejecutable
 *
 * @author JeffryACh
 * 
 * Ejecutable
 */
public class Ejecutable extends Proceso{
    // Atributos
    private final String[] MODOS = {"Si", "No"};
    private String esCooperativo;
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
    public Ejecutable() {
        super();
    }

    // Metodos
    // Getters y Setters
    /**
     * Metodo que retorna si el proceso es cooperativo o no
     * @return boolean - True si es cooperativo, false si no
     */
    public String isEsCooperativo() {
        return esCooperativo;
    }

    /**
     * Metodo que establece si el proceso es cooperativo o no
     * @param esCooperativo - True si es cooperativo, false si no
     */
    public void setEsCooperativo(String esCooperativo) {
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

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cambiarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getFechaDeEjecucion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setFechaDeEjecucion(String fechaDeEjecucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getHoraDeEjecucion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHoraDeEjecucion(String horaDeEjecucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getHoraDefinalizacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHoraDefinalizacion(String horaDefinalizacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
