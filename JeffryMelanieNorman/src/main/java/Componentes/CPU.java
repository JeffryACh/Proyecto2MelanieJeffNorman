/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Procesos.Proceso;
import java.util.ArrayList;
import ventanas.VentanaCPU;

/**
 * Esta clase es la encargada de mostrar los procesos en el CPU
 *
 * @author Melanie
 * 
 * CPU
 */
public class CPU implements Runnable{
    // Atributos
    private ArrayList<Proceso> procesos;
    private final int maxProcesos = 5;
    private int indiceActual = 0;
    // Constructor
    /**
     * Constructor de la clase CPU
     * @param i - int del numero de nucleos a usar
     */
    public CPU(int i){
        //this.procesos=procesos;
        VentanaCPU ventana=new VentanaCPU(i);
    }

    // Metodos


    /**
     * Metodo que ejecuta los procesos
     */
    public void ejecutarProcesos(){
        
    }
    /**
     * Metodo que agregar un proceso a la lista de procesos
     * @param proceso - Proceso a agregar
     */
    public void agregarProceso(Proceso proceso){
        procesos.add(proceso);
    }

    /**
     * Metodo que añaade un proceso a la lista de procesos
     * @param proceso - Proceso a agregar
     */
    public synchronized void añadirProceso(Proceso proceso) {
        if (procesos.size() < maxProcesos) {
            procesos.add(proceso);
            notify(); // Notifica si el hilo estaba esperando por procesos
        } else {
            // Manejar la situación cuando la CPU ya tiene 5 procesos
            // Por ejemplo, encolar el proceso en una lista de espera o algo similar
        }
    }

    /**
     * Metodo que ejecuta los procesos
     */
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (procesos.isEmpty()) {
                        wait(); // Espera si no hay procesos
                    }

                    if (indiceActual >= procesos.size()) {
                        indiceActual = 0; // Volver al inicio en Round Robin
                    }

                    Proceso actual = procesos.get(indiceActual);
                    Thread.sleep(1000); // Simula 1 segundo de ejecución
                    //actual.ejecutarTick();

                    /*if (actual.terminado()) {
                        procesos.remove(indiceActual);
                    } else {
                        indiceActual = (indiceActual + 1) % procesos.size();
                    }*/
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido");
        }
    
    }
}
