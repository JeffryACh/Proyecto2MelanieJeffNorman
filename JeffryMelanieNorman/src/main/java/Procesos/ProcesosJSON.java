/**
 *
 * @author nesa1
 */
package Procesos;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesosJSON {

    private static final String[] TIPOS_PROGRAMA = {"ejecutable", "multimedia", "documento"};
    private static final String[] NOMBRES_PROGRAMA = {"Editor", "Player", "Viewer", "Manager", "Explorer"};
    private static final int ID_MIN = 256;
    private static final int ID_MAX = 1024;
    private int ultimoId = ID_MIN - 1;
    private Random random = new Random();

    public JSONObject generarProceso(String usuario) {
        JSONObject proceso = new JSONObject();
        proceso.put("ID", obtenerSiguienteId());
        proceso.put("NombrePrograma", generarNombreAleatorio());
        proceso.put("TipoPrograma", TIPOS_PROGRAMA[random.nextInt(TIPOS_PROGRAMA.length)]);
        proceso.put("Usuario", usuario);

        return proceso;
    }

    private int obtenerSiguienteId() {
        if (ultimoId < ID_MAX) {
            ultimoId++;
        } else {
            ultimoId = ID_MIN;
        }
        return ultimoId;
    }

    private String generarNombreAleatorio() {
        String base = NOMBRES_PROGRAMA[random.nextInt(NOMBRES_PROGRAMA.length)];
        int numero = random.nextInt(100);
        return base + numero + ".exe";
    }

    public JSONObject generarProcesosPorUsuario(String usuario, int cantidad) {
        JSONArray procesos = new JSONArray();
        for (int i = 0; i < cantidad; i++) {
            procesos.put(generarProceso(usuario));
        }

        JSONObject root = new JSONObject();
        root.put("Procesos", procesos);
        return root;
    }

    public void guardarEnArchivo(JSONObject json, String nombreArchivo) {
        try (FileWriter file = new FileWriter(nombreArchivo)) {
            file.write(json.toString(4)); // Imprime con indentación para mejor visualización
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcesosJSON simulador = new ProcesosJSON();
        JSONObject procesosJson = simulador.generarProcesosPorUsuario("CarlosAP", 5);
        simulador.guardarEnArchivo(procesosJson, "ListaDeProcesos.json");

        Tipos clasificador = new Tipos();
        JSONObject programasJson = clasificador.clasificarProgramas(procesosJson.getJSONArray("Procesos"));
        simulador.guardarEnArchivo(programasJson, "Programas.JSON");
    }
}
