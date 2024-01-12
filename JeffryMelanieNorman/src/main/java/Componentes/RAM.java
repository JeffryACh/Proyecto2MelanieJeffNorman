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
    // Atributos
    private final int SIZE=128;
    private CPU[] cpus;
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
        cpus=new CPU[n];
        for(int i=1; i<=n; i++){
            cpus[i-1]=new CPU(i);
        }
    }

    /**
     * Metodo que asigna los procesos a los CPUs de manera aleatoria
     */
    private void asignarCPUs(){
        int cont=cpus.length;
        Random random=new Random();
        for(Proceso proceso:procesos){
            int n=random.nextInt();
            cpus[n%cont].agregarProceso(proceso);
            proceso.cambiarEstado(Estado.ESPERA);
        }
    }
    
}
