
package Componentes;

/**
 *
 * @author nesa1
 */
import java.util.LinkedList;
import java.util.Queue;
import Procesos.Estado;
import Procesos.Proceso;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestorMemoriaRAM implements Runnable {
    private final int maxRAMSize;
    private int availableRAMSize;
    private Queue<Proceso> waitingQueue; // Cola de espera para los procesos
    private ArrayList<Proceso> processesInRAM; // Procesos actualmente en RAM
    private final Object lock = new Object(); // Bloqueo para sincronización

    public GestorMemoriaRAM(int maxRAMSize) {
        this.maxRAMSize = maxRAMSize;
        this.availableRAMSize = maxRAMSize;
        this.waitingQueue = new LinkedList<>();
        this.processesInRAM = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    // Intenta asignar procesos a la RAM
                    while (!waitingQueue.isEmpty() && availableRAMSize >= waitingQueue.peek().getTamano()) {
                        Proceso proceso = waitingQueue.poll();
                        processesInRAM.add(proceso);
                        availableRAMSize -= proceso.getTamano();
                        // Aquí se debería iniciar la ejecución del proceso o asignarlo a un CPU
                        // Por ejemplo: cpu.asignarProceso(proceso);
                    }
                    lock.wait(); // Espera a que se libere memoria
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método para agregar procesos a la cola de espera
    public void agregarProceso(Proceso proceso) {
        synchronized (lock) {
            waitingQueue.add(proceso);
            lock.notify(); // Notifica al gestor de memoria que hay un nuevo proceso
        }
    }

    // Método para simular la finalización de un proceso y liberar su espacio
    public void finalizarProceso(Proceso proceso) {
        synchronized (lock) {
            if (processesInRAM.remove(proceso)) {
                availableRAMSize += proceso.getTamano();
                // Aquí se podría actualizar la interfaz gráfica si es necesario
                lock.notify(); // Notifica que se ha liberado memoria
            }
        }
    }
    
    
    
}