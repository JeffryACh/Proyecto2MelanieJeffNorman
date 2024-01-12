package Procesos;

import java.util.Random;

import Componentes.RAM;

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
public abstract class Proceso {
    // Atributos
    private int id;
    private String nombre;
    private String fechaDeEjecucion;
    private String horaDeEjecucion;
    private String horaDefinalizacion;
    private Estado estado;

    // Constructor
    /**
     * Constructor de la clase Proceso
     */
    public Proceso() {
        
    }

    // Metodos
    
    /**
     * Metodo que retorna el nombre del proceso
     * @return String nombre - Nombre del proceso
     */
    public abstract String getNombre();

    /**
     * Metodo que cambia el estado del proceso
     * @param estado
     */
    public abstract void cambiarEstado(Estado estado);

    /**
     * Metodo que modifica el nombre del proceso
     * @param nombre - Nombre del proceso
     */
    public abstract void setNombre(String nombre);

    /**
     * Metodo que retorna la fecha de ejecucion del proceso
     * @return String fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public abstract String getFechaDeEjecucion();

    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public abstract void setFechaDeEjecucion(String fechaDeEjecucion);

    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public abstract String getHoraDeEjecucion();

    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public abstract void setHoraDeEjecucion(String horaDeEjecucion);

    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public abstract String getHoraDefinalizacion();

    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public abstract void setHoraDefinalizacion(String horaDefinalizacion);

    /**
     * Metodo que retorna el identificador unico del proceso
     * @return int id - Identificador unico del proceso
     */
    public abstract int getId();

    /**
     * Metodo que modifica el identificador unico del proceso de forma aleatoria
     * @param id - Identificador unico del proceso
     */
    public abstract void setId(int id);
}
