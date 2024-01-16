package Componentes;

import java.util.LinkedList;
import java.util.Queue;
import Procesos.Estado;
import Procesos.Proceso;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase que simula la memoria RAM del sistema. Se encarga de asignar procesos a
 *
 * @author Norman
 * 
 * GestorMemoriaRAM.java
 */
public class GestorMemoriaRAM implements Runnable {
    private final int maxRAMSize;
    private int availableRAMSize;
    private Queue<Proceso> waitingQueue; // Cola de espera para los procesos
    private ArrayList<Proceso> processesInRAM; // Procesos actualmente en RAM
    private final Object lock = new Object(); // Bloqueo para sincronización

    /**
     * Constructor de la clase
     * @param maxRAMSize - Tamaño máximo de la memoria RAM
     */
    public GestorMemoriaRAM(int maxRAMSize) {
        this.maxRAMSize = maxRAMSize;
        this.availableRAMSize = maxRAMSize;
        this.waitingQueue = new LinkedList<>();
        this.processesInRAM = new ArrayList<>();
    }

    @Override
    /**
     * Método que se ejecuta en un hilo de ejecución. Se encarga de asignar
     */
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

    /**
     * Método para agregar un proceso a la cola de espera
     * @param proceso - Proceso a agregar
     */
    public void agregarProceso(Proceso proceso) {
        synchronized (lock) {
            waitingQueue.add(proceso);
            lock.notify(); // Notifica al gestor de memoria que hay un nuevo proceso
        }
    }

    /**
     * Método para finalizar un proceso. Se debe llamar a este método cuando un
     * @param proceso - Proceso a finalizar
     */
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