package ManejoPRS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private int cantidadProcesos;
    private String usuario; // se saca de la ruta del archivo, es el nombre del archivo sin la extencion
    private String rutaDelPRS;

    // Constructor
    /**
     * Constructor de la clase LeerPRS
     * @param rutaDelPRS - Ruta del archivo .prs
     */
    public LeerPRS(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
        this.usuario = sacarUsuario();
    }

    // Metodos
    /**
     * Metodo que se encarga de retornar el nombre de usuario del archivo .prs
     * @return usuario - Nombre del archivo .prs
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que se encarga de establecer el nombre de usuario del archivo .prs
     * @param usuario - Nombre del archivo .prs
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que se encarga de retornar los nombres de los archivos .prs
     * @return nombresArchivosPRS - Nombres de los archivos .prs
     */
    private String sacarUsuario(){
        String rutaSinPath = rutaDelPRS.substring(20, rutaDelPRS.length() - 4);
        return rutaSinPath;
    }

    /**
     * Metodo que se encarga de retornar los documentos de los archivos .prs
     * @return documentos - Documentos de los archivos .prs
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
     * @return ejecutables - Ejecutables de los archivos .prs
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
     * @return multimedia - Multimedia de los archivos .prs
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
     * @return documentos - Documentos de los archivos .prs
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
                    String fechaString = fechaActual.format(formato);
                    LocalTime horaActual = LocalTime.now();
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String hora = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    int tamano = Integer.parseInt(partes[1]);
                    int duracion = Integer.parseInt(partes[2]);
                    doc = new Documento(id, nombre, partes[4], partes[3], tamano, duracion);
                    doc.setHoraDeEjecucion(hora);
                    doc.setFechaDeEjecucion(fechaString);
                    documentos.add(doc);
                    this.cantidadProcesos++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documentos;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Ejecutable
     * @return ejecutables - Ejecutables de los archivos .prs
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
                    String fechaString = fechaActual.format(formato);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaActual = LocalTime.now();
                    String horaString = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    int tamano = Integer.parseInt(partes[1]);
                    int duracion = Integer.parseInt(partes[2]);
                    ejec = new Ejecutable(id, nombre, partes[5], partes[4], partes[3], tamano, duracion);
                    ejec.setHoraDeEjecucion(horaString);
                    ejec.setFechaDeEjecucion(fechaString);
                    ejecutables.add(ejec);
                    this.cantidadProcesos++;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return ejecutables;
    }

    /**
     * Metodo que se encarga de leer el archivo .prs y guardar los procesos de tipo Multimedia
     * @return multimedia - Multimedia de los archivos .prs
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
                    String fecha = fechaActual.format(formato);
                    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaActual = LocalTime.now();
                    String hora = horaActual.format(formatoHora);
                    String nombre = partes[0];
                    for (int i = 0; i < nombre.length(); i++) {
                        if (nombre.charAt(i) == '.') {
                            nombre = nombre.substring(0, i);
                        }
                    }
                    int tamano = Integer.parseInt(partes[1]);
                    int duracion = Integer.parseInt(partes[2]);
                    multi = new Multimedia(id, nombre, partes[4], partes[3], tamano, duracion);
                    multi.setHoraDeEjecucion(hora);
                    multi.setFechaDeEjecucion(fecha);
                    multimedia.add(multi);
                    this.cantidadProcesos++;
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
     * Metodo que se encarga de retornar la cantidad de procesos que hay en el archivo .prs
     * @return int cantidadProcesos - Cantidad de procesos que hay en el archivo .prs
     */
    public int getCantidadProcesos() {
        return cantidadProcesos;
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

    /**
     * Metodo que se encarga de mostrar los procesos de tipo Documento de forma ordenada
    */
    private void mostrarDocumentos(){
        for (int i = 0; i < documentos.size(); i++) {
            System.out.println("Nombre: " + documentos.get(i).getNombre());
            System.out.println("Fecha de ejecucion: " + documentos.get(i).getFechaDeEjecucion());
            System.out.println("Hora de ejecucion: " + documentos.get(i).getHoraDeEjecucion());
            System.out.println("Tamaño: " + documentos.get(i).getTamano());
            System.out.println("Duracion del proceso: " + documentos.get(i).getDuracion());
            System.out.println("Estado: " + documentos.get(i).getEstado());
            System.out.println("Es cifrado: " + documentos.get(i).isEsCifrado());
            System.out.println("Tipo: " + documentos.get(i).getTipo());
            System.out.println();
        }
    }

    /**
     * Metodo que se encarga de mostrar los procesos de tipo Ejecutable de forma ordenada
    */
    private void mostrarEjecutables(){
        for (int i = 0; i < ejecutables.size(); i++) {
            System.out.println("Nombre: " + ejecutables.get(i).getNombre());
            System.out.println("Fecha de ejecucion: " + ejecutables.get(i).getFechaDeEjecucion());
            System.out.println("Hora de ejecucion: " + ejecutables.get(i).getHoraDeEjecucion());
            System.out.println("Tamaño: " + ejecutables.get(i).getTamano());
            System.out.println("Duracion del proceso: " + ejecutables.get(i).getDuracion());
            System.out.println("Estado: " + ejecutables.get(i).getEstado());
            System.out.println("Es cooperativo: " + ejecutables.get(i).isEsCooperativo());
            System.out.println("Extencion: " + ejecutables.get(i).getExtencion());
            System.out.println("Tipo: " + ejecutables.get(i).getTipo());
            System.out.println();
        }
    }

    /**
     * Metodo que se encarga de mostrar los procesos de tipo Multimedia de forma ordenada
    */
    private void mostrarMultimedia(){
        for (int i = 0; i < multimedia.size(); i++) {
            System.out.println("Nombre: " + multimedia.get(i).getNombre());
            System.out.println("Fecha de ejecucion: " + multimedia.get(i).getFechaDeEjecucion());
            System.out.println("Hora de ejecucion: " + multimedia.get(i).getHoraDeEjecucion());
            System.out.println("Tamaño: " + multimedia.get(i).getTamano());
            System.out.println("Duracion del proceso: " + multimedia.get(i).getDuracion());
            System.out.println("Estado: " + multimedia.get(i).getEstado());
            System.out.println("Recurso: " + multimedia.get(i).getRecurso());
            System.out.println("Tipo: " + multimedia.get(i).getTipo());
            System.out.println();
        }
    }

    /**
     * Metodo que se encarga de mostrar los procesos de tipo Documento, Ejecutable y Multimedia de forma ordenada
     */
    public void mostrarProcesos(){
        System.out.println("Cantidad de procesos: " + cantidadProcesos);
        System.out.println("--------------------------------------------------");
        System.out.println("Archivo: " + usuario + ".prs");
        System.out.println("--------------------------------------------------");
        if(existenDocumentos()){
            System.out.println("Documentos: ");
            mostrarDocumentos();
            System.out.println("--------------------------------------------------");
        }
        
        if(existenEjecutables()){
            System.out.println("Ejecutables: ");
            mostrarEjecutables();
            System.out.println("--------------------------------------------------");
        }
        
        if(existenMultimedia()){
            System.out.println("Multimedia: ");
            mostrarMultimedia();
            System.out.println("--------------------------------------------------");
        }
    }
}