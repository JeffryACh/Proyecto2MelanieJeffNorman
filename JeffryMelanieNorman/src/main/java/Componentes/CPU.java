/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Procesos.Proceso;
import java.util.ArrayList;
import ventanas.VentanaCPU;

/**
 *
 * @author Melanie
 */
public class CPU {
    private ArrayList<Proceso> procesos;
    public CPU(int i){
        //this.procesos=procesos;
        VentanaCPU ventana=new VentanaCPU(i);
    }
    public void ejecutarProcesos(){
        
    }
    public void agregarProceso(Proceso proceso){
        procesos.add(proceso);
    }
}
