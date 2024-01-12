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
    private ArrayList<Proceso> procesos;
    public RAM(int n){
        VentanaRAM ventana=new VentanaRAM();
        generarCPUs(n);
        asignarCPUs();
        
    }

    private void generarCPUs(int n){
        cpus=new CPU[n];
        for(int i=1; i<=n; i++){
            cpus[i-1]=new CPU(i);
        }
    }
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
