/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

/**
 * Clase que representa un proceso de tipo Multimedia
 *
 * @author JeffryACh
 * 
 * Multimedia
 */
public class Multimedia extends Proceso {
    // Atributos
    private final String[] RECURSOS = {"Audio", "Video", "Ambos"};
    private String recurso;

    // Constructor
    /**
     * Constructor de la clase Multimedia
     * @param recurso - Recurso del proceso
     * @param id - Identificador del proceso
     * @param nombre - Nombre del proceso
     * @param tiempo
     * @param tamano
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public Multimedia(String recurso, int id, String nombre, int tiempo, int tamano, String fechaDeEjecucion, String horaDeEjecucion, String horaDefinalizacion) {
        super(id, nombre, tiempo, tamano, fechaDeEjecucion, horaDeEjecucion, horaDefinalizacion);
        this.recurso = recurso;
    }

    // Metodos
    // Getters y Setters
    /**
     * Metodo que retorna el recurso del proceso
     * @return String recurso - Recurso del proceso
     */
    public String getRecurso() {
        return recurso;
    }

    /**
     * Metodo que establece el recurso del proceso
     * @param recurso - Recurso del proceso
     */
    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }
}
