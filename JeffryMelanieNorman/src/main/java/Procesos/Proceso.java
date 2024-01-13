package Procesos;

import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Proceso
 *
 * @author JeffryACh
 * 
 * Clase que representa un proceso en general
 */
public class Proceso {
    // Atributos
    private int id;
    private String nombre;
    private LocalDate fechaDeEjecucion;
    private LocalTime horaDeEjecucion;
    private LocalTime horaDefinalizacion;
    private Estado estado;
    private int tiempo=0;
    private int tamano;
    private int contador=0;
    private boolean terminado=false;

    // Constructor
    /**
     * Constructor de la clase Proceso
     * @param id - Identificador unico del proceso 
     * @param nombre - Nombre del proceso
     * @param tiempo
     * @param tamano
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public Proceso(int id, String nombre, int tiempo, int tamano) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo=tiempo;
        this.tamano=tamano;
    }

    // Metodos
    
    /**
     * Metodo que retorna el nombre del proceso
     * @return String nombre - Nombre del proceso
     */
        public String getNombre() {
        return nombre;
    }
        public void cambiarEstado(Estado estado){
            this.estado=estado;
        }
    /**
     * Metodo que modifica el nombre del proceso
     * @param nombre - Nombre del proceso
     */
        public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna la fecha de ejecucion del proceso
     * @return String fechaDeEjecucion - Fecha de ejecucion del proceso
     */
        public LocalDate getFechaDeEjecucion() {
        return fechaDeEjecucion;
    }

    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public void setFechaDeEjecucion(LocalDate fechaDeEjecucion) {
        this.fechaDeEjecucion = fechaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public LocalTime getHoraDeEjecucion() {
        return horaDeEjecucion;
    }

    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public void setHoraDeEjecucion(LocalTime horaDeEjecucion) {
        this.horaDeEjecucion = horaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public LocalTime getHoraDefinalizacion() {
        return horaDefinalizacion;
    }

    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public void setHoraDefinalizacion(LocalTime horaDefinalizacion) {
        this.horaDefinalizacion = horaDefinalizacion;
    }

    /**
     * Metodo que retorna el identificador unico del proceso
     * @return int id - Identificador unico del proceso
     */
    public int getId() {
        return id;
    }
    
    public void aumentarSegundo(){
        this.contador++;
        if(contador==tiempo){
            terminado=true;
        }
    }
    
    public boolean getTerminado(){
        return terminado;
    }
}
