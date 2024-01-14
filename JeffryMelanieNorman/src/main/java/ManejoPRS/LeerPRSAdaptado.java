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

public class LeerPRSAdaptado {
    // Atributos
    private ArrayList<Documento> documentos;
    private ArrayList<Ejecutable> ejecutables;
    private ArrayList<Multimedia> multimedia;
    private int cantidadProcesos;
    private String usuario;
    private String rutaDelPRS;

    // Constructor
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
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public ArrayList<Ejecutable> getEjecutables() {
        return ejecutables;
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public int getCantidadProcesos() {
        return cantidadProcesos;
    }

    public String getUsuario() {
        return usuario;
    }
    

    public String getRutaDelPRS() {
        return rutaDelPRS;
    }

    // Métodos setters, si necesitas la funcionalidad de actualizar desde la GUI
    public void setEjecutables(ArrayList<Ejecutable> ejecutables) {
        this.ejecutables = ejecutables;
    }

    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public void setRutaDelPRS(String rutaDelPRS) {
        this.rutaDelPRS = rutaDelPRS;
    }
    
    
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
     *
     * @param linea La línea del archivo PRS a procesar.
     * @return Un objeto Ejecutable o null si la línea no corresponde a un proceso ejecutable.
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
     * @param nombreArchivo El nombre del archivo con extensión.
     * @return El nombre del archivo sin la extensión.
     */
    private String obtenerNombreSinExtension(String nombreArchivo) {
        int puntoIndex = nombreArchivo.lastIndexOf('.');
        return puntoIndex != -1 ? nombreArchivo.substring(0, puntoIndex) : nombreArchivo;
    }
    
    

    private ArrayList<Multimedia> leerPRSMultimedia() {
        ArrayList<Multimedia> multimedia = new ArrayList<Multimedia>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaDelPRS))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes[3].equals("multimedia")) {
                    Random random = new Random();
                    int id = random.nextInt(1000);
                    Multimedia multi;
                    // Resto del código para crear y añadir un objeto Multimedia a la lista...
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return multimedia;
    }

    // Métodos existenDocumentos y existenEjecutables...

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

    // Método adaptado para leer el archivo .prs
    public void leerPRS() {
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
    }
    
    // Métodos adaptados para obtener la información de los procesos de manera estructurada
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

    
    // Método para obtener la información de los objetos Multimedia
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
    
    private boolean existenEjecutables() {
        throw new UnsupportedOperationException("Unimplemented method 'existenEjecutables'");
    }

    private boolean existenDocumentos() {
        throw new UnsupportedOperationException("Unimplemented method 'existenDocumentos'");
    }
    
    
    // Método para mostrar la información de todos los procesos
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

        if (existenMultimedia()) {
            infoTotal.add("Multimedia:\n");
            infoTotal.addAll(obtenerInformacionMultimedia());
            infoTotal.add("--------------------------------------------------\n");
        }

        return infoTotal;
    }
}
