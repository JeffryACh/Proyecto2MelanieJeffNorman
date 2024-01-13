package Procesos;

import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase que representa un proceso en general
 *
 * @author JeffryACh
 * 
 * Proceso
 */
public abstract class Proceso {
    // Atributos
    private int id;
    private String tipo;
    private String nombre;
    private String fechaDeEjecucion;
    private String horaDeEjecucion;
    private String horaDefinalizacion;
    private Estado estado;
    private int tiempo=0;
    private int tamano;
    private int contador=0;
    private boolean terminado=false;

    // Constructor
    /**
     * Constructor de la clase Proceso
     * @param id - Id del proceso
     * @param nombre - Nombre del proceso
     * @param tipo - Tipo de proceso
     */
    public Proceso(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.estado = Estado.ESPERA;
        this.tipo = tipo;
    }

    // Metodos
    
    /**
     * Metodo que retorna el nombre del proceso
     * @return String nombre - Nombre del proceso
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Metodo que cambia el estado del proceso
     * @param estado - Estado del proceso
     */
    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Metodo que retorna el estado del proceso
     * @return Estado estado - Estado del proceso
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Metodo que modifica el nombre del proceso
     * @param nombre - Nombre del proceso
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna la fecha de ejecucion del proceso
     * @return String fechaDeEjecucion - Fecha de ejecucion del proceso
     */
        public String getFechaDeEjecucion() {
        return fechaDeEjecucion;
    }

    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public void setFechaDeEjecucion(String fechaDeEjecucion) {
        this.fechaDeEjecucion = fechaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public String getHoraDeEjecucion() {
        return horaDeEjecucion;
    }

    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public void setHoraDeEjecucion(String horaDeEjecucion) {
        this.horaDeEjecucion = horaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public String getHoraDefinalizacion() {
        return horaDefinalizacion;
    }

    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public void setHoraDefinalizacion(String horaDefinalizacion) {
        this.horaDefinalizacion = horaDefinalizacion;
    }

    /**
     * Metodo que retorna el identificador unico del proceso
     * @return int id - Identificador unico del proceso
     */
    public int getId(){
        return this.id;
    }

    /**
     * Metodo que modifica el identificador unico del proceso de forma aleatoria
     * @param id - Identificador unico del proceso
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Metodo que retorna el tipo de proceso
     * @return String tipo - Tipo de proceso
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Metodo que modifica el tipo de proceso
     * @param tipo - Tipo de proceso
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    /**
     * Metodo que retorna el tiempo de ejecucion del proceso
     */
    public void aumentarSegundo(){
        this.contador++;
        if(contador==tiempo){
            terminado=true;
        }
    }
    
    /**
     * Metodo que retorna el tiempo de ejecucion del proceso
     * @return int tiempo - Tiempo de ejecucion del proceso
     */
    public boolean getTerminado(){
        return terminado;
    }
}
