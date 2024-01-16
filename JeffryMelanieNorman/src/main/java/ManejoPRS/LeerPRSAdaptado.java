package ManejoPRS;
/**
 * NO ESTÄ TERMINADO
 */
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
 * Esta clase lee un archivo .prs
 * 
 * @author Norman
 * 
 * LerrPRSAdaptado
 */
public class LeerPRSAdaptado {
    // Atributos
    private ArrayList<Documento> documentos;
    private ArrayList<Ejecutable> ejecutables;
    private ArrayList<Multimedia> multimedia;
    private int cantidadProcesos;
    private String usuario;
    private String rutaDelPRS;

    // Constructor
    /**
     * Este es el constructor de la clase LeerPRSAdaptado
     * @param rutaDelPRS - path de la carpeta donde estan los .prs
     */
    public LeerPRSAdaptado(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
        this.usuario = sacarUsuarioDeRuta(rutaDelPRS);
        this.documentos = new ArrayList<>();
        this.ejecutables = new ArrayList<>();
        this.multimedia = new ArrayList<>();
    }

    // Método para extraer el nombre de usuario de la ruta del archivo
    private String sacarUsuarioDeRuta(String ruta) {
        // Implementación depende del formato de la ruta
        String nombreArchivo = rutaDelPRS.substring(rutaDelPRS.lastIndexOf("/") + 1);
        return nombreArchivo.replace(".prs", "");
    }

    // Métodos de acceso
    /**
     * Get de los procesos tipo documentos
     * @return documentos - la lista de procesos de tipo documento
     */
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Get de los procesos tipo ejecutables
     * @return ejecutables - la lista de procesos de tipo ejecutable
     */
    public ArrayList<Ejecutable> getEjecutables() {
        return ejecutables;
    }

    /**
     * Get de los procesos de tipo multimedia
     * @return multimedia - la lista de procesos de tipo multimedia
     */
    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    /**
     * Get cantidad de procesos totales
     * @return cantidadProcesos - int de los procesos totales
     */
    public int getCantidadProcesos() {
        return cantidadProcesos;
    }

    /**
     * Get del usuario del archivo .prs
     * @return usuario - nombre de usuario
     */
    public String getUsuario() {
        return usuario;
    }
    

    /**
     * Get de la ruta de la carpeta donde estan los .prs
     * @return rutaDelPRS - aqui estan los .prs
     */
    public String getRutaDelPRS() {
        return rutaDelPRS;
    }

    // Métodos setters, si necesitas la funcionalidad de actualizar desde la GUI
    /**
     * Set Ejecutables, este metodo modifica los procesos de tipo ejecutables
     * @param ejecutables - lista de ejecutables
     */
    public void setEjecutables(ArrayList<Ejecutable> ejecutables) {
        this.ejecutables = ejecutables;
    }

    /**
     * Set Multimedia, este metodo modifica los procesos de tipo multimedia
     * @param multimedia - lista de multimedias
     */
    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * Set de la ruta de la carpeta de los .prs
     * @param rutaDelPRS - nuevo path de los prs
     */
    public void setRutaDelPRS(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
    }
    
    /**
     * Lee el archivo PRS y extrae los procesos de tipo Documento.
     * @param rutaDelArchivo - La ruta del archivo PRS a leer.
     * @return documentos - Una lista de objetos Documento extraídos del archivo.
     * @throws IOException - Si ocurre un error al leer el archivo.
     */
    public ArrayList<Documento> leerPRSDocumentos(String rutaDelArchivo) throws IOException {
        ArrayList<Documento> documentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Documento doc = procesarLineaDocumento(linea);
                if (doc != null) {
                    documentos.add(doc);
                    this.cantidadProcesos++;
                }
            }
        }
        return documentos;
    }

    /**
     * Procesa una línea del archivo PRS y crea un objeto Documento si la línea corresponde a un proceso documento.
     * @param linea - La línea del archivo PRS a procesar.
     * @return doc - Un objeto Documento o null si la línea no corresponde a un proceso documento.
     */
    private Documento procesarLineaDocumento(String linea) {
        String[] partes = linea.split(", ");
        if (!partes[3].equals("documento")) {
            return null;
        }
        

        int id = new Random().nextInt(1000);
        String nombre = obtenerNombreSinExtension(partes[0]);
        int tamano = Integer.parseInt(partes[1]);
        int duracion = Integer.parseInt(partes[2]);
        String tipo = partes[3];
        String fechaString = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        Documento doc = new Documento(id, nombre, partes[4], tipo, tamano, duracion);
        doc.setHoraDeEjecucion(hora);
        doc.setFechaDeEjecucion(fechaString);

        return doc;
    }
    
        /**
     * Lee el archivo PRS y extrae los procesos de tipo Ejecutable.
     *
     * @param rutaDelArchivo La ruta del archivo PRS a leer.
     * @return Una lista de objetos Ejecutable extraídos del archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public ArrayList<Ejecutable> leerPRSEjecutable(String rutaDelArchivo) throws IOException {
        ArrayList<Ejecutable> ejecutables = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Ejecutable ejec = procesarLineaEjecutable(linea);
                if (ejec != null) {
                    ejecutables.add(ejec);
                    this.cantidadProcesos++;
                }
            }
        }
        return ejecutables;
    }

    /**
     * Procesa una línea del archivo PRS y crea un objeto Ejecutable si la línea corresponde a un proceso ejecutable.
     * @param linea - La línea del archivo PRS a procesar.
     * @return ejec - Un objeto Ejecutable o null si la línea no corresponde a un proceso ejecutable.
     */
    private Ejecutable procesarLineaEjecutable(String linea) {
        String[] partes = linea.split(", ");
        if (!partes[3].equals("ejecutable")) {
            return null;
        }

        int id = new Random().nextInt(1000);
        String nombre = obtenerNombreSinExtension(partes[0]);
        int tamano = Integer.parseInt(partes[1]);
        int duracion = Integer.parseInt(partes[2]);
        String tipo = partes[3];
        String fechaString = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String horaString = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        Ejecutable ejec = new Ejecutable(id, nombre, partes[5], partes[4], tipo, tamano, duracion);
        ejec.setHoraDeEjecucion(horaString);
        ejec.setFechaDeEjecucion(fechaString);

        return ejec;
    }

    /**
     * Obtiene el nombre de un archivo sin su extensión.
     *
     * @param nombreArchivo - El nombre del archivo con extensión.
     * @return El nombre del archivo sin extensión.
     */
    private String obtenerNombreSinExtension(String nombreArchivo) {
        int puntoIndex = nombreArchivo.lastIndexOf('.');
        return puntoIndex != -1 ? nombreArchivo.substring(0, puntoIndex) : nombreArchivo;
    }
    
    


    /**
     * Lee el archivo PRS y extrae los procesos de tipo Multimedia.
     * @param rutaDelPRS - La ruta del archivo PRS a leer.
     * @return multimedia - Una lista de objetos Multimedia extraídos del archivo.
     * @throws IOException
     */
    private ArrayList<Multimedia> leerPRSMultimedia(String rutaDelPRS) throws IOException{
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
     * Verifica si existen procesos de tipo Documento en el archivo PRS.
     * @return boolean - true si existen procesos de tipo Documento, false si no.
     * @throws IOException - Si ocurre un error al leer el archivo.
     */
    public boolean existenMultimedia() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes[3].equals("multimedia")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verifica si existen procesos de tipo Ejecutable en el archivo PRS.
     */
    public void leerPRS() {
        try {
            // Verificar y leer Documentos
            if (existenDocumentos()) {
                this.documentos = leerPRSDocumentos(this.rutaDelPRS);
            }

            // Verificar y leer Ejecutables
            if (existenEjecutables()) {
                this.ejecutables = leerPRSEjecutable(this.rutaDelPRS);
            }

            // Verificar y leer Multimedia
            if (existenMultimedia()) {
                this.multimedia = leerPRSMultimedia(this.rutaDelPRS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene la información de los objetos Documento.
     * @return info - Una lista de Strings con la información de los objetos Documento.
     */
    public ArrayList<String> obtenerInformacionDocumentos() {
        ArrayList<String> info = new ArrayList<>();
        for (Documento doc : documentos) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(doc.getNombre())
              .append("\nFecha de ejecucion: ").append(doc.getFechaDeEjecucion())
              .append("\nHora de ejecucion: ").append(doc.getHoraDeEjecucion())
              .append("\nTamaño: ").append(doc.getTamano())
              .append("\nDuracion del proceso: ").append(doc.getDuracion())
              .append("\nEstado: ").append(doc.getEstado())
              .append("\nEs cifrado: ").append(doc.isEsCifrado())
              .append("\nTipo: ").append(doc.getTipo()).append("\n");
            info.add(sb.toString());
        }
        return info;
    }

    /**
     * Obtiene la información de los objetos Ejecutable.
     * @return info - Una lista de Strings con la información de los objetos Ejecutable.
     */
    public ArrayList<String> obtenerInformacionEjecutables() {
        ArrayList<String> info = new ArrayList<>();
        for (Ejecutable ejec : ejecutables) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(ejec.getNombre())
              .append("\nFecha de ejecucion: ").append(ejec.getFechaDeEjecucion())
              .append("\nHora de ejecucion: ").append(ejec.getHoraDeEjecucion())
              .append("\nTamaño: ").append(ejec.getTamano())
              .append("\nDuracion del proceso: ").append(ejec.getDuracion())
              .append("\nEstado: ").append(ejec.getEstado())
              .append("\nEs cooperativo: ").append(ejec.isEsCooperativo())
              .append("\nExtencion: ").append(ejec.getExtencion())
              .append("\nTipo: ").append(ejec.getTipo()).append("\n");
            info.add(sb.toString());
        }
        return info;
    }

    
    /**
     * Obtiene la información de los objetos Multimedia.
     * @return infoMultimedia - Una lista de Strings con la información de los objetos Multimedia.
     */
    public ArrayList<String> obtenerInformacionMultimedia() {
        ArrayList<String> infoMultimedia = new ArrayList<>();
        for (Multimedia multi : multimedia) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(multi.getNombre()).append("\n");
            sb.append("Fecha de ejecución: ").append(multi.getFechaDeEjecucion()).append("\n");
            sb.append("Hora de ejecución: ").append(multi.getHoraDeEjecucion()).append("\n");
            sb.append("Tamaño: ").append(multi.getTamano()).append("\n");
            sb.append("Duración del proceso: ").append(multi.getDuracion()).append("\n");
            sb.append("Estado: ").append(multi.getEstado()).append("\n");
            sb.append("Recurso: ").append(multi.getRecurso()).append("\n");
            sb.append("Tipo: ").append(multi.getTipo()).append("\n\n");
            infoMultimedia.add(sb.toString());
        }
        return infoMultimedia;
    }
    
    /**
     * Esta funcion valida la existencia de procesos de tipo ejecutables
     * @return boolean - true si existen / false si no
     */
    private boolean existenEjecutables() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes[3].equals("ejecutable")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Esta funcion valida la existencia de procesos de tipo documento
     * @return boolean - true si existen / false si no
     */
    private boolean existenDocumentos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes[3].equals("documento")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Esta funcion valida la existencia de procesos de tipo multimedia
     * @return boolean - true si existen / false si no
     */
    private boolean existenMultimedias(){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(", ");
                if(partes[3].equals("multimedia")){
                    return true;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    // Método para mostrar la información de todos los procesos
    /**
     * Esta funcion obtiene toda la info del prs en una lista de str
     * @return infoTotal - toda la info en lista de str
     */
    public ArrayList<String> obtenerInformacionDeTodosLosProcesos() {
        ArrayList<String> infoTotal = new ArrayList<>();
        infoTotal.add("Cantidad de procesos: " + cantidadProcesos + "\n--------------------------------------------------\n");
        infoTotal.add("Archivo: " + usuario + ".prs\n--------------------------------------------------\n");

        if (existenDocumentos()) {
            infoTotal.add("Documentos:\n");
            infoTotal.addAll(obtenerInformacionDocumentos());
            infoTotal.add("--------------------------------------------------\n");
        }

        if (existenEjecutables()) {
            infoTotal.add("Ejecutables:\n");
            infoTotal.addAll(obtenerInformacionEjecutables());
            infoTotal.add("--------------------------------------------------\n");
        }

        if (existenMultimedias()) {
            infoTotal.add("Multimedia:\n");
            infoTotal.addAll(obtenerInformacionMultimedia());
            infoTotal.add("--------------------------------------------------\n");
        }

        return infoTotal;
    }
}
