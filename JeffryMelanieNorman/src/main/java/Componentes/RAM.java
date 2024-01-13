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
 *
 * @author Melanie
 */
public class RAM {
    private final int size=128;
    private CPU[] cpus; 
    private Thread[] threads;
    private ArrayList<Proceso> procesos;
    public RAM(int n){
        VentanaRAM ventana=new VentanaRAM();
        generarCPUs(n);
        asignarCPUs();
        
    }

    private void generarCPUs(int n){
        cpus = new CPU[n];
        threads = new Thread[n];
        for(int i = 0; i < n; i++){
            CPU cpu = new CPU(i);
            Thread threadcpu = new Thread(cpu);
            cpus[i] = cpu;
            threads[i] = threadcpu;
        }
    }
    private void asignarCPUs(){
        int cont = cpus.length;
        Random random = new Random();
        for(Proceso proceso : procesos){
            int n = random.nextInt(cont); 
            cpus[n].agregarProceso(proceso); 
            proceso.cambiarEstado(Estado.ASIGNADO);
        }
    }
   
    private void ejecutar(){
        if(threads != null){
            for(int i = 0; i < threads.length; i++){
                threads[i].start();
            }
        }
    }
}
