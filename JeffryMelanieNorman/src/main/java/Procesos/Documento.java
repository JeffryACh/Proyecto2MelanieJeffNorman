/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que representa un proceso de tipo Documento
 *
 * @author JeffryACh
 * 
 * Documento
 */
public class Documento extends Proceso {
    // Atributos
    private final String[] MODOS = {"cifrado", "descifrado"};
    private String esCifrado;

    // Constructor
    /**
     * Constructor de la clase Documento
     * @param id - Id del proceso
     * @param nombre - Nombre del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param estado - Estado del proceso
     * @param esCifrado - cifrado o descifrado
     * @param tipo - Tipo de proceso
     */
    public Documento(int id, String nombre, String esCifrado, String tipo) {
        super(id, nombre, tipo);
        this.esCifrado = esCifrado;
    }

    /**
     * Metodo que retorna si el documento es cifrado o no
     * @return boolean esCifrado - True si es cifrado, false si no
     */
    public String isEsCifrado() {
        return esCifrado;
    }

    /**
     * Metodo que establece si el documento es cifrado o no
     * @param esCifrado - True si es cifrado, false si no
     */
    public void setEsCifrado(String esCifrado) {
        this.esCifrado = esCifrado;
    }  

    @Override
    /**
     * Metodo que retorna el nombre del proceso
     * @return String nombre - Nombre del proceso
     */
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    /**
     * Metodo que cambia el estado del proceso
     * @param estado - Estado del proceso
     */
    public void cambiarEstado(Estado estado) {
        this.cambiarEstado(estado);
    }

    @Override
    /**
     * Metodo que modifica el nombre del proceso
     * @param nombre - Nombre del proceso
     */
    public void setNombre(String nombre) {
        this.setNombre(nombre);
    }

    @Override
    /**
     * Metodo que retorna la fecha de ejecucion del proceso
     * @return String fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public LocalDate getFechaDeEjecucion() {
        return super.getFechaDeEjecucion();
    }

    @Override
    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public void setFechaDeEjecucion(LocalDate fechaDeEjecucion) {
        this.setFechaDeEjecucion(fechaDeEjecucion);
    }

    @Override
    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public LocalTime getHoraDeEjecucion() {
        return super.getHoraDeEjecucion();
    }

    @Override
    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public void setHoraDeEjecucion(LocalTime horaDeEjecucion) {
        this.setHoraDeEjecucion(horaDeEjecucion);
    }

    @Override
    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public LocalTime getHoraDefinalizacion() {
        return super.getHoraDefinalizacion();
    }

    @Override
    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public void setHoraDefinalizacion(LocalTime horaDefinalizacion) {
        this.setHoraDefinalizacion(horaDefinalizacion);
    }

    @Override
    /**
     * Metodo que retorna el id del proceso
     * @return int id - Id del proceso
     */
    public int getId() {
        return super.getId();
    }

    @Override
    /**
     * Metodo que modifica el id del proceso
     * @param id - Id del proceso
     */
    public void setId(int id) {
        this.setId(id);
    }

    @Override
    /**
     * Metodo que retorna el estado del proceso
     * @return Estado estado - Estado del proceso
     */
    public Estado getEstado() {
        return super.getEstado();
    }

    @Override
    /**
     * Metodo que retorna el tipo de proceso
     * @return String tipo - Tipo de proceso
     */
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    /**
     * Metodo que modifica el tipo de proceso
     * @param tipo - Tipo de proceso
     */
    public void setTipo(String tipo) {
        this.setTipo(tipo);
    }
}
