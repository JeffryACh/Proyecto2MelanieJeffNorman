package Procesos;

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
    private String fechaDeEjecucion;
    private String horaDeEjecucion;
    private String horaDefinalizacion;

    // Constructor
    /**
     * Constructor de la clase Proceso
     * @param id - Identificador unico del proceso 
     * @param nombre - Nombre del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public Proceso(int id, String nombre, String fechaDeEjecucion, String horaDeEjecucion, String horaDefinalizacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeEjecucion = fechaDeEjecucion;
        this.horaDeEjecucion = horaDeEjecucion;
        this.horaDefinalizacion = horaDefinalizacion;
    }

    // Metodos
    
    /**
     * Metodo que retorna el nombre del proceso
     * @return String nombre - Nombre del proceso
     */
        public String getNombre() {
        return nombre;
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
    public int getId() {
        return id;
    }
}
