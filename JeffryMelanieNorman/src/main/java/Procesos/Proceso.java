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
    private String tipo;
    private Estado estado;

    // Constructor
    /**
     * Constructor de la clase Proceso
     * @param id - Id del proceso
     * @param nombre - Nombre del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param estado - Estado del proceso
     * @param tipo - Tipo de proceso
     */
    public Proceso(int id, String nombre, String fechaDeEjecucion, String horaDeEjecucion, Estado estado, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeEjecucion = fechaDeEjecucion;
        this.horaDeEjecucion = horaDeEjecucion;
        this.estado = estado;
        this.tipo = tipo;
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
     * Metodo que retorna el estado del proceso
     * @return Estado estado - Estado del proceso
     */
    public abstract Estado getEstado();

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
    public abstract String getFechaDeEjecucion();

    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public void setFechaDeEjecucion(String fechaDeEjecucion){
        this.fechaDeEjecucion = fechaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public abstract String getHoraDeEjecucion();

    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public void setHoraDeEjecucion(String horaDeEjecucion){
        this.horaDeEjecucion = horaDeEjecucion;
    }

    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public abstract String getHoraDefinalizacion();

    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public void setHoraDefinalizacion(String horaDefinalizacion){
        this.horaDefinalizacion = horaDefinalizacion;
    }

    /**
     * Metodo que retorna el identificador unico del proceso
     * @return int id - Identificador unico del proceso
     */
    public abstract int getId();

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
    public abstract String getTipo();

    /**
     * Metodo que modifica el tipo de proceso
     * @param tipo - Tipo de proceso
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
