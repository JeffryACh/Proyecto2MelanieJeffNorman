/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoPRS;

import java.io.File;
import java.util.ArrayList;

import Procesos.Proceso;

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
    private ArrayList<LeerPRSAdaptado> lector;

    // Constructor
    /**
     * Constructor de la clase ManejoPRS
     */
    public ManejoPRS() {
        this.nombresArchivosPRS = new ArrayList<>();
        this.rutasArchivosPRS = new ArrayList<>();
        this.lector = new ArrayList<>();
        buscarArchivosPRS();
        buscarRutasArchivosPRS();
        leerArchivosPRS();
    }

    // Metodos
    /**
     * Metodo que se encarga de retornar los nombres de los archivos .prs
     * @return nombresArchivosPRS - Nombres de los archivos .prs
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
     * @return rutasArchivosPRS - Rutas de los archivos .prs
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
    public ArrayList<LeerPRSAdaptado> getLector() {
        return lector;
    }

    /**
     * Metodo que se encarga de establecer el lector de los archivos .prs
     * @param lector - Lector de los archivos .prs
     */
    public void setLector(ArrayList<LeerPRSAdaptado> lector) {
        this.lector = lector;
    }

    /**
     * Metodo que se encarga de verificar si existen archivos .prs en RUTA_DIRECTORIO
     * @return boolean - True si existen archivos .prs, false si no existen
     */
    private boolean existenArchivosPRS() {
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
     * @return nombresArchivosPRS - Nombres de los archivos .prs
     */
    private ArrayList<String> buscarArchivosPRS() {
        if (existenArchivosPRS()) {
            File directorio = new File(RUTA_DIRECTORIO);
            File[] archivos = directorio.listFiles();
            
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    String nombre = archivo.getName();
                    for (int i = 0; i < nombre.length(); i++){
                        if (nombre.charAt(i) == '.'){
                            nombre = nombre.substring(0, i);
                            break;
                        }
                    }
                    this.nombresArchivosPRS.add(nombre);
                }
            }
            return nombresArchivosPRS;
        }
        System.out.println("No se encontraron archivos .prs");
        return null;
    }

    /**
     * Metodo que se encarga de buscar los archivos .prs en rutaDirectorio para retornar sus rutas
     * @return rutasArchivosPRS - Rutas de los archivos .prs
     */
    private ArrayList<String> buscarRutasArchivosPRS() {
        if (existenArchivosPRS()) {
            File directorio = new File(RUTA_DIRECTORIO);
            File[] archivos = directorio.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    this.rutasArchivosPRS.add(RUTA_DIRECTORIO + "/" + archivo.getName());
                }
            }
        }
        
        return rutasArchivosPRS;
    }

    /**
     * Metodo que se encarga de leer los archivos .prs
     * @return LeerPRS lector - Lector de los archivos .prs
     */
    private ArrayList<LeerPRSAdaptado> leerArchivosPRS() {
        if (existenArchivosPRS()) {
            for (String rutaArchivo : rutasArchivosPRS) {
                LeerPRSAdaptado lectorp = new LeerPRSAdaptado(rutaArchivo);
                lectorp.leerPRS();
                this.lector.add(lectorp);
            }
        }
        return lector;
    }

    /**
     * Metodo que se encarga de retornar el lector de un archivo .prs
     * @param nombreArchivo - Nombre del archivo .prs
     * @return procesosLista - ArrayList de procesos del archivo .prs
     */
    public ArrayList<Proceso> getProcesos(String nombreArchivo) {
        for (LeerPRSAdaptado lectorp : lector) {
            if (lectorp.getRutaDelPRS().equals(nombreArchivo)) {
                return lectorp.obtenerProcesos();
            }
        }
        return null;
    }
}
