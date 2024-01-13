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
        ManejoPRS manejo = new ManejoPRS();

        manejo.getLector().forEach((lector) -> {
            lector.mostrarProcesos();
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");
        });
    }
}

