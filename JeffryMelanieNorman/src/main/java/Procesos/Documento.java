/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

/**
 * Documento
 *
 * @author JeffryACh
 * 
 * Clase que representa un proceso de tipo Documento
 */
public class Documento extends Proceso {
    // Atributos
    private boolean esCifrado;

    // Constructor
    /**
     * Constructor de la clase Documento
     * @param id - Identificador del proceso
     * @param nombre - Nombre del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     * @param esCifrado - True si es cifrado, false si no
     */
    public Documento(int id, String nombre, String fechaDeEjecucion, String horaDeEjecucion, String horaDefinalizacion, boolean esCifrado) {
        super(id, nombre, fechaDeEjecucion, horaDeEjecucion, horaDefinalizacion);
        this.esCifrado = esCifrado;
    }

    /**
     * Metodo que retorna si el documento es cifrado o no
     * @return boolean esCifrado - True si es cifrado, false si no
     */
    public boolean isEsCifrado() {
        return esCifrado;
    }

    /**
     * Metodo que establece si el documento es cifrado o no
     * @param esCifrado - True si es cifrado, false si no
     */
    public void setEsCifrado(boolean esCifrado) {
        this.esCifrado = esCifrado;
    }  
}
