package Procesos;

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
    private String usuario;
    private int tiempo=0;
    private int duracion;
    private int tamano;
    private int contador=0;
    private boolean terminado;
    private int CPU;

    // Constructor
    /**
     * Constructor de la clase Proceso
     * @param id - Id del proceso
     * @param nombre - Nombre del proceso
     * @param tipo - Tipo de proceso
     * @param tamano - Tamaño del proceso
     * @param duracion - Duracion del proceso
     */
    public Proceso(int id, String nombre, String tipo, int tamano, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.estado = Estado.ESPERA;
        this.tipo = tipo;
        this.tamano = tamano;
        this.duracion = duracion;
        this.terminado=false;
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
     * Metodo que retorna el usuario del proceso
     * @return usuario - Usuario del proceso
     */
    public String getUsuario(){
        return usuario;
    }
    
    /**
     * Metodo que modifica el usuario del proceso
     * @param usuario - Usuario del proceso
     */
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }

    /**
     * Metodo que retorna el contador del proceso
     * @return contador - Contador del proceso
     */
    public int getCont(){
        return contador;
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
     * Metodo que retorna el CPU del proceso
     * @return CPU - numero de la CPU del proceso
     */
    public int getCPU(){
        return CPU;
    }

    /**
     * Metodo que modifica el CPU del proceso
     * @param n - numero de la CPU del proceso
     */
    public void setCPU(int n){
        this.CPU=n;
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
     * Metodo que aumenta el contador del proceso y verifica si el proceso ha terminado
     */
    public void aumentarSegundo(){
        this.contador++;
        if(contador==duracion){
            setTerminado();
        }
    }
    
    /**
     * Metodo que modifica el estado del proceso a terminado
     */
    public void setTerminado(){
        this.terminado=true;
    }

    /**
     * Metodo que retorna el estado del proceso
     * @return boolean terminado - Estado del proceso
     */
    public boolean getTerminado(){
        return terminado;
    }

    /**
     * Metodo que retorna el tiempo de ejecucion del proceso
     * @return tiempo - Tiempo de ejecucion del proceso
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Metodo que modifica el tiempo de ejecucion del proceso
     * @param tiempo - Tiempo de ejecucion del proceso
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Metodo que retorna la duracion del proceso
     * @return duracion - Duracion del proceso
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Metodo que modifica la duracion del proceso
     * @param duracion - Duracion del proceso
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo que retorna el tamano del proceso
     * @return tamano - Tamano del proceso
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Metodo que modifica el tamano del proceso
     * @param tamano - Tamano del proceso
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * Metodo que retorna el contador del proceso
     * @return contador - Contador del proceso
     */
    public int getContador() {
        return contador;
    }

    /**
     * Metodo que modifica el contador del proceso
     * @param contador - Contador del proceso
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * Metodo que retorna el estado del proceso
     * @return terminado - Estado del proceso
     */
    public boolean isTerminado() {
        return terminado;
    }

    /**
     * Metodo que modifica el estado del proceso
     * @param terminado - Estado del proceso
     */
    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    
}