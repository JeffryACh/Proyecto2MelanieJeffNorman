/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    // Constructor
    /**
     * Constructor de la clase RAM
     * @param n - int del numero de nucleos a usar
     */
    public RAM(int n){
        VentanaRAM ventana=new VentanaRAM();
        generarCPUs(n);
        asignarCPUs();
        
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
            }
        }
    }
   
    /**
     * Metodo que ejecuta los procesos
     */
    public void ejecutar(){
        if(threads != null){
            for(int i = 0; i < threads.length; i++){
                threads[i].start();
            }
        }
    }
}
