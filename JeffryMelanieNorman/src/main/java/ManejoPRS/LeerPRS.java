package ManejoPRS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

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
     * @return ArrayList<Documento> documentos - Documentos de los archivos .prs
     */
    private ArrayList<Documento> leerPRSDocumentos() {
        ArrayList<Documento> documentos = new ArrayList<Documento>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes[3].equals("documento")) {
                    Random random = new Random();
                    int id = random.nextInt(1000);
                    Documento doc;
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaActual = LocalDate.now();
                    String fechaComoCadena = fechaActual.format(formato);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaActual = LocalTime.now();
                    String horaComoCadena = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    doc = new Documento(id, nombre, fechaComoCadena, horaComoCadena, Estado.ESPERA, partes[4], partes[3]);
                    documentos.add(doc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentos;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Ejecutable
     * @return ArrayList<Ejecutable> ejecutables - Ejecutables de los archivos .prs
     */
    private ArrayList<Ejecutable> leerPRSEjecutable(){
        ArrayList<Ejecutable> ejecutables = new ArrayList<Ejecutable>();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");

                if(partes[3].equals("ejecutable")){
                    Random random = new Random();
                    int id = random.nextInt(1000);
                    Ejecutable ejec;
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaActual = LocalDate.now();
                    String fechaComoCadena = fechaActual.format(formato);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaActual = LocalTime.now();
                    String horaComoCadena = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    ejec = new Ejecutable(id, nombre, fechaComoCadena, horaComoCadena, Estado.ESPERA, partes[5], partes[4], partes[3]);
                    ejecutables.add(ejec);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return ejecutables;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Multimedia
     * @return ArrayList<Multimedia> multimedia - Multimedia de los archivos .prs
     */
    private ArrayList<Multimedia> leerPRSMultimedia(){
        ArrayList<Multimedia> multimedia = new ArrayList<Multimedia>();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");

                if(partes[3].equals("multimedia")){
                    Random random = new Random();
                    int id = random.nextInt(1000);
                    Multimedia multi;
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaActual = LocalDate.now();
                    String fechaComoCadena = fechaActual.format(formato);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaActual = LocalTime.now();
                    String horaComoCadena = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    multi = new Multimedia(id, nombre, fechaComoCadena, horaComoCadena, Estado.ESPERA, partes[4], partes[3]);
                    multimedia.add(multi);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return multimedia;
    }

    /**
     * Metodo que se encarga de leer el .prs y verificar que existan procesos de tipo Documento
     * @return boolean - True si existen procesos de tipo Documento, false si no
     */
    private boolean existenDocumentos(){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");

                if(partes[3].equals("documento")){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Metodo que se encarga de leer el .prs y verificar que existan procesos de tipo Ejecutable
     * @return boolean - True si existen procesos de tipo Ejecutable, false si no
     */
    private boolean existenEjecutables(){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");

                if(partes[3].equals("ejecutable")){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Metodo que se encarga de leer el .prs y verificar que existan procesos de tipo Multimedia
     * @return boolean - True si existen procesos de tipo Multimedia, false si no
     */
    private boolean existenMultimedia(){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");

                if(partes[3].equals("multimedia")){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Documento, Ejecutable y Multimedia
     */
    public void leerPRS(){
        
        if(existenDocumentos()){
            this.documentos = leerPRSDocumentos();
        }
        
        if(existenEjecutables()){
            this.ejecutables = leerPRSEjecutable();
        }
        
        if(existenMultimedia()){
            this.multimedia = leerPRSMultimedia();
        }
    }
}