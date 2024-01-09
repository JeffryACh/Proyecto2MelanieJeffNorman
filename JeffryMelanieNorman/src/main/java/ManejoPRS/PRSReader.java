/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoPRS;

/**
 *
 * @author nesa1
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class PRSReader {

    public static void main(String[] args) {
        String directoryPath = "."; // Ruta del directorio (puede ser relativa o absoluta)

        File dir = new File(directoryPath);
        FilenameFilter filter = (dir1, name) -> name.endsWith(".prs");

        File[] prsFiles = dir.listFiles(filter);

        if (prsFiles != null) {
            for (File file : prsFiles) {
                System.out.println("Contenido de " + file.getName() + ":");
                printFileContent(file);
                System.out.println();
            }
        }
    }

    private static void printFileContent(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

