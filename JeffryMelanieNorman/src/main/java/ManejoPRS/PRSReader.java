/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoPRS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import Componentes.ListaProcesos;
import Procesos.Estado;
/**
 * Clase que se encarga de leer los archivos .prs
 *
 * @author Norman
 * 
 * PRSReader
 */
public class PRSReader {

    /**
     * Constructor de la clase PRSReader
     */
    public PRSReader() {
    }

    /**
     * Método principal
     * @param args  - Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("Leyendo archivos .prs");
        ListaProcesos lista = new ListaProcesos();
        System.out.println("====================================");
        System.out.println("Procesos leidos:\n");
        System.out.println("====================================");
        System.out.println("Elija el tipo de estado que desea ver (1, 2, 3, 4 o 0)");
        System.out.println("1. Espera");
        System.out.println("2. Asignado");
        System.out.println("3. Finalizado");
        System.out.println("4. Todos");
        System.out.println("0. Salir");
        System.out.println("====================================");
        System.out.println("Ingrese el numero de la opcion que desea ver");
        System.out.println("====================================");
        int opcion = 0;
        try {
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            opcion = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Error al leer la opcion");
        }
        while (true) {
            if (opcion == 1) {
                System.out.println("====================================");
                System.out.println("Procesos en espera:\n");
                System.out.println("====================================");
                lista.imprimirProcesosPorEstado(Estado.ESPERA);
            } else if (opcion == 2) {
                System.out.println("====================================");
                System.out.println("Procesos asignados:\n");
                System.out.println("====================================");
                lista.imprimirProcesosPorEstado(Estado.ASIGNADO);
            } else if (opcion == 3) {
                System.out.println("====================================");
                System.out.println("Procesos finalizados:\n");
                System.out.println("====================================");
                lista.imprimirProcesosPorEstado(Estado.FINALIZADO);
            } else if (opcion == 4) {
                System.out.println("====================================");
                System.out.println("Procesos:\n");
                System.out.println("====================================");
                lista.imprimirProcesos();
            } else if (opcion == 0) {
                System.out.println("====================================");
                System.out.println("Saliendo...");
                System.out.println("====================================");
                break;
            }
            System.out.println("====================================");
            System.out.println("Procesos leidos:\n");
            System.out.println("====================================");
            System.out.println("Elija el tipo de estado que desea ver (1, 2, 3, 4 o 0)");
            System.out.println("1. Espera");
            System.out.println("2. Asignado");
            System.out.println("3. Finalizado");
            System.out.println("4. Todos");
            System.out.println("0. Salir");
            System.out.println("====================================");
            System.out.println("Ingrese el numero de la opcion que desea ver");
            System.out.println("====================================");
            try {
                BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
                opcion = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                System.out.println("Error al leer la opcion");
            }
            while (opcion < 1 || opcion > 4) {
                System.out.println("====================================");
                System.out.println("Ingrese una opcion valida");
                System.out.println("====================================");
                try {
                    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
                    opcion = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    System.out.println("Error al leer la opcion");
                }
            }
        }
    }
}

