package Componentes;

import Procesos.Estado;
import Procesos.Proceso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import ventanas.VentanaRAM;

/**
 * Esta clase es la encargada de mostrar los procesos en el CPU
 *
 * @author Melanie
 * 
 * RAM
 */
public class RAM implements Runnable{
    //Atributos
    private final int size=128;
    private int usado=0;
    private CPU[] cpus; 
    private Thread[] threads;
    private ArrayList<Proceso> procesos;
    private ListaProcesos lista;
    VentanaRAM ventana;
        

    // Constructor
    /**
     * Constructor de la clase RAM
     * @param n - int del numero de nucleos a usar
     * @param list - Lista de procesos
     */
    public RAM(int n, ListaProcesos list){
        procesos=new ArrayList<>();
        lista=list;
        ventana=new VentanaRAM();
        ventana.setVisible(true);
        generarCPUs(n);
        asignarProcesos();
        //this.gestorMemoriaRAM = new GestorMemoriaRAM(this.size);
        //this.threadGestorMemoria = new Thread(gestorMemoriaRAM);
        //this.threadGestorMemoria.start();
        
    }
    @Override
    /**
     * Método que se ejecuta en un hilo de ejecución. Se encarga de asignar
     */
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    while(lista.getProcesos().isEmpty() && procesos.isEmpty()){
                        wait();
                    }
                    // Intenta actualizar los procesos de la RAM
                    actualizarProcesos();
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Metodos
    /**
     * Metodo que añaade un proceso a la lista de procesos
     * @param proceso - Proceso a agregar
     */
    public synchronized void agregarProceso(Proceso proceso) {
        procesos.add(proceso);
        notify(); 
    }
    /**
     * Metodo que genera los CPUs
     * @param n - int del numero de nucleos a crear
     */
    private void generarCPUs(int n){
        cpus = new CPU[n];
        threads = new Thread[n];
        for(int i = 0; i < n; i++){
            CPU cpu = new CPU(i+1);
            Thread threadcpu = new Thread(cpu);
            cpus[i] = cpu;
            threads[i] = threadcpu;
        }
    }
    // Método para finalizar procesos y liberar memoria
    //public void finalizarProceso(Proceso proceso) {
        //this.gestorMemoriaRAM.finalizarProceso(proceso);
    //}
    
    
    // Método modificado para agregar procesos al gestor de memoria
    //public void agregarProcesoARAM(Proceso proceso){
        //this.gestorMemoriaRAM.agregarProceso(proceso);
    //}
    /**
     * Metodo que asigna los procesos a la RAM
     */
    public void asignarProcesos(){
        
        while (!lista.getProcesos().isEmpty()) {
            Proceso proceso = siguienteEnEspera();
            if (proceso == null || usado + proceso.getTamano() > size) {
                break; 
            }

            agregarProceso(proceso);
            usado += proceso.getTamano();
            asignarCPU(proceso);
        }

        ventana.cargarDatos(procesos);
        lista.cargarDatos();
    }
    /**
     * Metodo que actualiza los procesos de la RAM
     */
    public synchronized void actualizarProcesos() {
        if (procesos != null) {
            ArrayList<Proceso> procesosNuevos = new ArrayList<>();
            Iterator<Proceso> iterator = procesos.iterator();
            while (iterator.hasNext()) {
                Proceso proceso = iterator.next();
                if (proceso != null && proceso.getEstado().equals(Estado.FINALIZADO)) {
                    iterator.remove(); // Elimina el proceso de manera segura
                    usado -= proceso.getTamano();
                    Proceso nuevoProceso = siguienteEnEspera();
                    if (nuevoProceso != null) {
                        procesosNuevos.add(nuevoProceso); // Acumula procesos nuevos
                    }
                }
            }
            // Añadir los nuevos procesos después de la iteración
            for (Proceso nuevoProceso : procesosNuevos) {
                agregarProceso(nuevoProceso);
                usado += nuevoProceso.getTamano();
                asignarCPU(nuevoProceso);
            }
            ventana.cargarDatos(procesos);
        }
        lista.cargarDatos();
    }


    /*public void actualizarProcesos(){
        if(procesos!=null && !procesos.isEmpty()){
            for(Proceso proceso: procesos){
                if(proceso.getEstado().equals(Estado.FINALIZADO)){
                    procesos.remove(proceso);
                    usado-=proceso.getTamano();
                    proceso=siguienteEnEspera();
                    asignarCPU(proceso);
                    ventana.cargarDatos(procesos);
                }
            }
        }
        
    }
    */
    /**
     * Metodo que retorna el siguiente proceso en espera
     * @return proceso - Proceso en espera
     */
    public Proceso siguienteEnEspera(){  
        if(lista.getProcesos()!=null && !lista.getProcesos().isEmpty()){
            for(Proceso proceso: lista.getProcesos()){
                if(proceso.getEstado().equals(Estado.ESPERA)){
                    return proceso;
                }
            }
        }
        return null;
    }
    
    /**
     * Metodo que asigna los procesos a los CPUs de manera aleatoria
     */
    private void asignarCPUs(){
        if(procesos!=null){
            int cont = cpus.length;
            Random random = new Random();
            for(Proceso proceso : procesos){
                int n = random.nextInt(cont); 
                cpus[n].agregarProceso(proceso); 
                proceso.cambiarEstado(Estado.ASIGNADO);
                proceso.setCPU(n+1);
            }
        }
    }
    
    /**
     * Metodo que asigna un proceso a un CPU de manera aleatoria
     * @param proceso - Proceso a asignar
     */
    private void asignarCPU(Proceso proceso){
        if(proceso!=null){
            Random random = new Random();
            int n = random.nextInt(cpus.length); 
            cpus[n].agregarProceso(proceso); 
            proceso.cambiarEstado(Estado.ASIGNADO);
            proceso.setCPU(n+1);
        }
    }
    /**
     * Metodo que ejecuta los procesos
     */
    public void ejecutar(){
        if(threads != null){
            for (Thread thread : threads) {
                thread.start();
            }
        }
        lista.cargarDatos();
    }
    
    /**
     * Metodo que cierra la ventana
     */
    public void cerrarVentana(){
        ventana.setVisible(false);
        for(CPU cpu:cpus){
            cpu.getVentana().setVisible(false);
        }
    }
    
}

