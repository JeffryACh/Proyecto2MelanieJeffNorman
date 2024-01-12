/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jeffrymelanienorman;

import ventanas.VentanaCPU;
import ventanas.VentanaInicio;
/**
 * Esta clase es la encargada de mostrar los procesos en el CPU
 *
 * @author JeffryACh
 * 
 * JeffryMelanieNorman
 */
public class JeffryMelanieNorman {
    /**
     * Creates new form CPU
     */
    public JeffryMelanieNorman() {
    }
    /**
     * Creates new form CPU
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        VentanaInicio inicio=new VentanaInicio();
        inicio.setVisible(true);
        VentanaCPU cpu=new VentanaCPU(1);
        cpu.setVisible(true);
    }
}
