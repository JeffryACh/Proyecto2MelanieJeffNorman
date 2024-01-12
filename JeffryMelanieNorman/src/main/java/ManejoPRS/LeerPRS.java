package ManejoPRS;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que se encarga de leer los archivos .prs
 * 
 * @author JeffryACh
 * 
 * LeerPRS
 */
public class LeerPRS {
    // Atributos
    private final String rutaDirectorio = "./src/main/java/PRS";
    /**
     * Lista de archivos .prs
     */
    private ArrayList<File> archivosPRS;

    // Constructor
    /**
     * Constructor de la clase LeerPRS
     */
    public LeerPRS() {
        this.archivosPRS = buscarArchivosPRS(rutaDirectorio);
    }

    /**
     * Método que busca los archivos .prs en el directorio
     * @param rutaDirectorio - Ruta del directorio donde se encuentran los archivos .prs
     * @return archivosPRS - Lista de archivos .prs
     */
    public ArrayList<File> buscarArchivosPRS(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivos = directorio.listFiles();
        ArrayList<File> archivosPRS = new ArrayList<>();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".prs")) {
                    archivosPRS.add(archivo);
                }
            }
        }

        return archivosPRS;
    }
}
