package Componentes;

import Procesos.Estado;
import Procesos.Proceso;
import java.util.ArrayList;
import java.util.Random;
import ventanas.VentanaRAM;

/**
 * Esta clase es la encargada de mostrar los procesos en el CPU
 *
 * @author Melanie
 * 
 * RAM
 */
public class RAM {
    //Atributos
    private final int size=128;
    private CPU[] cpus; 
    private Thread[] threads;
    private ArrayList<Proceso> procesos;
    private GestorMemoriaRAM gestorMemoriaRAM;
    private Thread threadGestorMemoria;

    // Constructor
    /**
     * Constructor de la clase RAM
     * @param n - int del numero de nucleos a usar
     */
    public RAM(int n){
        VentanaRAM ventana=new VentanaRAM();
        generarCPUs(n);
        asignarCPUs();
        this.gestorMemoriaRAM = new GestorMemoriaRAM(this.size);
        this.threadGestorMemoria = new Thread(gestorMemoriaRAM);
        this.threadGestorMemoria.start();
        
    }

    // Metodos
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
    public void finalizarProceso(Proceso proceso) {
        this.gestorMemoriaRAM.finalizarProceso(proceso);
    }
    
    
    // Método modificado para agregar procesos al gestor de memoria
    public void agregarProcesoARAM(Proceso proceso){
    this.gestorMemoriaRAM.agregarProceso(proceso);
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
     * Metodo que ejecuta los procesos
     */
    public void ejecutar(){
        if(threads != null){
            for (Thread thread : threads) {
                thread.start();
            }
        }
        // Aquí se puede poner la Lógica para la ejecución de procesos
    }
    
    
}

