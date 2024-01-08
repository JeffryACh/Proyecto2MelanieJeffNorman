/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

/**
 *
 * @author XPC
 */
public class Documento extends Proceso {
    // Atributos
    private boolean formato; // true = cifrado, false = descifrado

    public Documento(int id, String nombre, String fechaDeEjecucion, String horaDeEjecucion, String horaDefinalizacion, boolean formato) {
        super(id, nombre, fechaDeEjecucion, horaDeEjecucion, horaDefinalizacion);
        this.formato = formato;
    }

    /**
     * Metodo que retorna el formato del documento
     * @return boolean formato - Formato del documento (true = cifrado, false = descifrado)
     */
    public boolean isFormato() {
        return formato;
    }

    /**
     * Metodo que modifica el formato del documento
     * @param formato - Formato del documento (true = cifrado, false = descifrado)
     */
    public void setFormato(boolean formato) {
        this.formato = formato;
    }

    
    
}
