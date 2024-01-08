/**
 *
 * @author nesa1
 */
package Procesos;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Random;

public class Tipos {

    private Random random = new Random();

    public JSONObject clasificarProgramas(JSONArray procesos) {
        JSONObject clasificaciones = new JSONObject();

        for (int i = 0; i < procesos.length(); i++) {
            JSONObject proceso = procesos.getJSONObject(i);
            String usuario = proceso.getString("Usuario");
            JSONArray programasUsuario = clasificaciones.optJSONArray(usuario);

            if (programasUsuario == null) {
                programasUsuario = new JSONArray();
                clasificaciones.put(usuario, programasUsuario);
            }

            JSONObject infoPrograma = new JSONObject();
            infoPrograma.put("NombrePrograma", proceso.getString("NombrePrograma"));
            infoPrograma.put("TipoPrograma", proceso.getString("TipoPrograma"));
            infoPrograma.put("Detalles", obtenerDetalles(proceso.getString("TipoPrograma")));

            programasUsuario.put(infoPrograma);
        }

        return clasificaciones;
    }

    private JSONObject obtenerDetalles(String tipoPrograma) {
        JSONObject detalles = new JSONObject();
        switch (tipoPrograma) {
            case "ejecutable":
                detalles.put("Extension", random.nextBoolean() ? "exe" : "bat");
                detalles.put("Cooperativo", random.nextBoolean() ? "Sí" : "No");
                break;
            case "multimedia":
                int eleccion = random.nextInt(3);
                detalles.put("Recursos", eleccion == 0 ? "video" : eleccion == 1 ? "sonido" : "ambos");
                break;
            case "documento":
                detalles.put("Formato", random.nextBoolean() ? "texto plano" : "cifrado");
                break;
        }
        return detalles;
    }
}

