/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Procesos.Estado;
import Procesos.Proceso;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private Proceso[] ejecutando;
    private int indiceActual = 0;
    private VentanaCPU ventana;
    // Constructor
    /**
     * Constructor de la clase CPU
     * @param i - int del numero de CPU
     */
    public CPU(int i){
        ejecutando=new Proceso[5];
        procesos=new ArrayList<>();
        ventana=new VentanaCPU(i);
        ventana.setVisible(true);
    }

    // Metodos

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
        procesos.add(proceso);
        notify(); 
    }

    /**
     * Metodo que ejecuta los procesos
     */
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (ejecutando.length==0 && procesos.isEmpty()) {
                        wait(); 
                    }
                    for(int j=0; j<ejecutando.length; j++){
                        if(ejecutando[j]==null && !procesos.isEmpty()){
                            ejecutando[j]=asignarProceso();
                        }
                    }
                    if (indiceActual >= ejecutando.length) {
                        indiceActual = 0; 
                    }

                    Proceso actual = ejecutando[indiceActual];
                    Thread.sleep(1000); 
                    actual.aumentarSegundo();

                    if (actual.getTerminado()) {
                        actual.cambiarEstado(Estado.FINALIZADO);
                        actual.setHoraDefinalizacion(LocalTime.now());
                        int i=indiceActual;
                        while(i<ejecutando.length-1 && ejecutando[i+1]!=null){
                            ejecutando[i]=ejecutando[i+1];
                            ejecutando[i+1]=null;
                            i++;
                        }
                        if(!procesos.isEmpty() && ejecutando[i]==null){
                            ejecutando[i]=asignarProceso();
                        }
                    } else {
                        int cont=0;
                        for(int i=0; i<ejecutando.length; i++){
                            if(ejecutando[i]!=null){
                                cont++;
                            }
                        }
                        indiceActual = (indiceActual + 1) % cont;
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido");
        }
    
    }
    
    /**
     * Metodo que asigna un proceso
     * @return Proceso actual - Proceso asignado
     */
    public Proceso asignarProceso(){
        Proceso actual= procesos.get(0);
        procesos.remove(0);
        actual.setFechaDeEjecucion(LocalDate.now());
        actual.setHoraDeEjecucion(LocalTime.now());
        return actual;
    }
}
