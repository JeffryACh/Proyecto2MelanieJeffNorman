/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

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
     * @param id - Id del proceso
     * @param nombre - Nombre del proceso
     * @param esCooperativo - Cooperativo o no
     * @param extencion - Extencion del archivo
     * @param tipo - Tipo de proceso
     * @param tamano - Tamaño del proceso
     * @param duracion - Duracion del proceso
     */
    public Ejecutable(int id, String nombre, String esCooperativo, String extencion, String tipo, int tamano, int duracion) {
        super(id, nombre, tipo, tamano, duracion);
        this.esCooperativo = esCooperativo;
        this.extencion = extencion;
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
        super.cambiarEstado(estado);
    }

    @Override
    /**
     * Metodo que modifica el nombre del proceso
     * @param nombre - Nombre del proceso
     */
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    /**
     * Metodo que retorna la fecha de ejecucion del proceso
     * @return String fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public String getFechaDeEjecucion() {
        return super.getFechaDeEjecucion();
    }

    @Override
    /**
     * Metodo que modifica la fecha de ejecucion del proceso
     * @param fechaDeEjecucion - Fecha de ejecucion del proceso
     */
    public void setFechaDeEjecucion(String fechaDeEjecucion) {
        super.setFechaDeEjecucion(fechaDeEjecucion);
    }

    @Override
    /**
     * Metodo que retorna la hora de ejecucion del proceso
     * @return String horaDeEjecucion - Hora de ejecucion del proceso
     */
    public String getHoraDeEjecucion() {
        return super.getHoraDeEjecucion();
    }

    @Override
    /**
     * Metodo que modifica la hora de ejecucion del proceso
     * @param horaDeEjecucion - Hora de ejecucion del proceso
     */
    public void setHoraDeEjecucion(String horaDeEjecucion) {
        super.setHoraDeEjecucion(horaDeEjecucion);
    }

    @Override
    /**
     * Metodo que retorna la hora de finalizacion del proceso
     * @return String horaDefinalizacion - Hora de finalizacion del proceso
     */
    public String getHoraDefinalizacion() {
        return super.getHoraDefinalizacion();
    }

    @Override
    /**
     * Metodo que modifica la hora de finalizacion del proceso
     * @param horaDefinalizacion - Hora de finalizacion del proceso
     */
    public void setHoraDefinalizacion(String horaDefinalizacion) {
        super.setHoraDefinalizacion(horaDefinalizacion);
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
        super.setId(id);
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
        super.setTipo(tipo);
    }

    @Override
    /**
     * Metodo que retorna el tamaño del proceso
     * @return int tamano - Tamaño del proceso
     */
    public int getTamano() {
        return super.getTamano();
    }

    @Override
    /**
     * Metodo que modifica el tamaño del proceso
     * @param tamano - Tamaño del proceso
     */
    public void setTamano(int tamano) {
        super.setTamano(tamano);
    }

    @Override
    /**
     * Metodo que retorna la duracion del proceso
     * @return int duracion - Duracion del proceso
     */
    public int getDuracion() {
        return super.getDuracion();
    }

    @Override
    /**
     * Metodo que modifica la duracion del proceso
     * @param duracion - Duracion del proceso
     */
    public void setDuracion(int duracion) {
        super.setDuracion(duracion);
    }

    @Override
    /**
     * Metodo que retorna el tiempo de ejecucion del proceso
     * @return int tiempo - Tiempo de ejecucion del proceso
     */
    public int getTiempo() {
        return super.getTiempo();
    }

    @Override
    /**
     * Metodo que modifica el tiempo de ejecucion del proceso
     * @param tiempo - Tiempo de ejecucion del proceso
     */
    public void setTiempo(int tiempo) {
        super.setTiempo(tiempo);
    }

    @Override
    /**
     * Metodo que retorna el estado del proceso
     * @return boolean terminado - Estado del proceso
     */
    public boolean getTerminado() {
        return super.getTerminado();
    }

    @Override
    /**
     * Metodo que modifica el estado del proceso
     * @param terminado - Estado del proceso
     */
    public void setTerminado(boolean terminado) {
        super.setTerminado(terminado);
    }
}
