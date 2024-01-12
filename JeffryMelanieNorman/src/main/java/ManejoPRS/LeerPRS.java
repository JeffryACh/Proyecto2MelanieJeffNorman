package ManejoPRS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Procesos.*;

/**
 * Clase que se encarga de leer los archivos .prs
 * 
 * @author JeffryACh
 * 
 * LeerPRS
 */
public class LeerPRS {
    // Atributos
    private ArrayList<Documento> documentos;
    private ArrayList<Ejecutable> ejecutables;
    private ArrayList<Multimedia> multimedia;
    private String rutaDelPRS;

    // Constructor
    /**
     * Constructor de la clase LeerPRS
     * @param documentos - Documentos de los archivos .prs
     * @param ejecutables - Ejecutables de los archivos .prs
     * @param multimedia - Multimedia de los archivos .prs
     */
    public LeerPRS(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
    }

    // Metodos
    /**
     * Metodo que se encarga de retornar los documentos de los archivos .prs
     * @return ArrayList<String> nombresArchivosPRS - Nombres de los archivos .prs
     */
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Metodo que se encarga de establecer los documentos de los archivos .prs
     * @param documentos - Documentos de los archivos .prs
     */
    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * Metodo que se encarga de retornar los ejecutables de los archivos .prs
     * @return ArrayList<Ejecutable> ejecutables - Ejecutables de los archivos .prs
     */
    public ArrayList<Ejecutable> getEjecutables() {
        return ejecutables;
    }

    /**
     * Metodo que se encarga de establecer los ejecutables de los archivos .prs
     * @param ejecutables - Ejecutables de los archivos .prs
     */
    public void setEjecutables(ArrayList<Ejecutable> ejecutables) {
        this.ejecutables = ejecutables;
    }

    /**
     * Metodo que se encarga de retornar los multimedia de los archivos .prs
     * @return ArrayList<Multimedia> multimedia - Multimedia de los archivos .prs
     */
    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    /**
     * Metodo que se encarga de establecer los multimedia de los archivos .prs
     * @param multimedia - Multimedia de los archivos .prs
     */
    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * Metodo que se encarga de retornar la ruta del archivo .prs
     * @return String rutaDelPRS - Ruta del archivo .prs
     */
    public String getRutaDelPRS() {
        return rutaDelPRS;
    }

    /**
     * Metodo que se encarga de establecer la ruta del archivo .prs
     * @param rutaDelPRS - Ruta del archivo .prs
     */
    public void setRutaDelPRS(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Documento
     */
    private void leerPRSDocumentos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes[3].equals("documento")) {
                    Documento doc = new Documento();
                    doc.setNombre(partes[0]);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaActual = LocalDate.now();
                    String fechaComoCadena = fechaActual.format(formato);
                    doc.(fechaComoCadena);
                    doc.setHoraLectura(Integer.parseInt(partes[2]));
                    doc.setTipo(partes[3]);
                    doc.setDatos(partes[4]);

                    documentos.add(doc);

                    Date fechaHoraActual = new Date();
                    System.out.println("Fecha de uso: " + fechaHoraActual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
