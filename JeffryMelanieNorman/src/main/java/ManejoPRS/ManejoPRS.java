/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoPRS;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que se encarga de manejar los archivos .prs
 *
 * @author JeffryACh
 * 
 * ManejoPRS
 */
public class ManejoPRS {
    // Atributos
    private final String RUTA_DIRECTORIO = "./src/main/java/PRS";
    private ArrayList<String> nombresArchivosPRS;
    private ArrayList<String> rutasArchivosPRS;
    private LeerPRS lector;

    // Constructor
    /**
     * Constructor de la clase ManejoPRS
     * @param nombresArchivosPRS - Nombres de los archivos .prs
     * @param rutasArchivosPRS - Rutas de los archivos .prs
     * @param lector - Lector de los archivos .prs
     */
    public ManejoPRS(ArrayList<String> nombresArchivosPRS, ArrayList<String> rutasArchivosPRS, LeerPRS lector) {
        this.nombresArchivosPRS = nombresArchivosPRS;
        this.rutasArchivosPRS = rutasArchivosPRS;
        this.lector = lector;
    }

    // Metodos
    /**
     * Metodo que se encarga de retornar los nombres de los archivos .prs
     * @return ArrayList<String> nombresArchivosPRS - Nombres de los archivos .prs
     */
    public ArrayList<String> getNombresArchivosPRS() {
        return nombresArchivosPRS;
    }

    /**
     * Metodo que se encarga de establecer los nombres de los archivos .prs
     * @param nombresArchivosPRS - Nombres de los archivos .prs
     */
    public void setNombresArchivosPRS(ArrayList<String> nombresArchivosPRS) {
        this.nombresArchivosPRS = nombresArchivosPRS;
    }

    /**
     * Metodo que se encarga de retornar las rutas de los archivos .prs
     * @return ArrayList<String> rutasArchivosPRS - Rutas de los archivos .prs
     */
    public ArrayList<String> getRutasArchivosPRS() {
        return rutasArchivosPRS;
    }

    /**
     * Metodo que se encarga de establecer las rutas de los archivos .prs
     * @param rutasArchivosPRS - Rutas de los archivos .prs
     */
    public void setRutasArchivosPRS(ArrayList<String> rutasArchivosPRS) {
        this.rutasArchivosPRS = rutasArchivosPRS;
    }

    /**
     * Metodo que se encarga de retornar el lector de los archivos .prs
     * @return LeerPRS lector - Lector de los archivos .prs
     */
    public LeerPRS getLector() {
        return lector;
    }

    /**
     * Metodo que se encarga de establecer el lector de los archivos .prs
     * @param lector - Lector de los archivos .prs
     */
    public void setLector(LeerPRS lector) {
        this.lector = lector;
    }

    /**
     * Metodo que se encarga de verificar si existen archivos .prs en RUTA_DIRECTORIO
     * @return boolean - True si existen archivos .prs, false si no existen
     */
    public boolean existenArchivosPRS() {
        File directorio = new File(RUTA_DIRECTORIO);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Metodo que se encarga de buscar los archivos .prs en rutaDirectorio para retornar sus nombres
     * @return ArrayList<String> nombresArchivosPRS - Nombres de los archivos .prs
     */
    public ArrayList<String> buscarArchivosPRS() {
        if (existenArchivosPRS()) {
            File directorio = new File(RUTA_DIRECTORIO);
            File[] archivos = directorio.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    nombresArchivosPRS.add(archivo.getName());
                    rutasArchivosPRS.add(archivo.getAbsolutePath());
                }
            }
        }
        
        return nombresArchivosPRS;
    }

    /**
     * Metodo que se encarga de buscar los archivos .prs en rutaDirectorio para retornar sus rutas
     * @return ArrayList<String> rutasArchivosPRS - Rutas de los archivos .prs
     */
    public ArrayList<String> buscarRutasArchivosPRS() {
        if (existenArchivosPRS()) {
            File directorio = new File(RUTA_DIRECTORIO);
            File[] archivos = directorio.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    rutasArchivosPRS.add(RUTA_DIRECTORIO + "/" + archivo.getName());
                }
            }
        }
        
        return rutasArchivosPRS;
    }

    /**
     * Metodo que se encarga de leer los archivos .prs
     * @return LeerPRS lector - Lector de los archivos .prs
     */
    
}
