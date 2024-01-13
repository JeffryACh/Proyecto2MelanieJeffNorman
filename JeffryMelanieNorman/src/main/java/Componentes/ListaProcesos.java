/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Procesos.Documento;
import Procesos.Estado;
import Procesos.Proceso;
import java.util.ArrayList;

import javax.swing.text.Document;

import ManejoPRS.ManejoPRS;

/**
 * Esta clase es la encargada de mostrar los procesos en el CPU
 *
 * @author Melanie
 * 
 * ListaProcesos
 */
public class ListaProcesos {
    // Atributos
    private ManejoPRS manejo;

    // Constructor
    /**
     * Constructor de la clase ListaProcesos
     */
    public ListaProcesos(){
        manejo = new ManejoPRS();
    }

    // Metodos
    /**
     * Metodo que se encarga de retornar los procesos que se encuentran en el CPU
     * @return manejo - Manejo de los archivos .prs
     */
    public ManejoPRS getManejo() {
        return manejo;
    }

    /**
     * Metodo que se encarga de establecer los procesos que se encuentran en el CPU
     * @param manejo - Manejo de los archivos .prs
     */
    public void setManejo(ManejoPRS manejo) {
        this.manejo = manejo;
    }

    /**
     * Metodo que se encarga de retornar los procesos de tipo Documento
     * @return procesosDocumento - ArrayList de procesos de tipo Documento
     */
    private ArrayList<Documento> sacarDocumentos(){
        ArrayList<Documento> procesosDocumento = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    System.out.println(documento.getNombre());
                    procesosDocumento.add(documento);
                });
            }
            else{
                System.out.println("No hay documentos");
                return ;
            }
        }); 
        return procesosDocumento;
    }

    /**
     * Metodo que se encarga de retornar los procesos de tipo Multimedia
     * @return procesosMultimedia - ArrayList de procesos de tipo Multimedia
     */
    private ArrayList<Proceso> sacarMultimedia(){
        ArrayList<Proceso> procesosMultimedia = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    System.out.println(multimedia.getNombre());
                    procesosMultimedia.add(multimedia);
                });
            }
            else{
                System.out.println("No hay multimedia");
                return ;
            }
        }); 
        return procesosMultimedia;
    }

    /**
     * Metodo que se encarga de retornar los procesos de tipo Ejecutable
     * @return procesosEjecutable - ArrayList de procesos de tipo Ejecutable
     */
    private ArrayList<Proceso> sacarEjecutables(){
        ArrayList<Proceso> procesosEjecutable = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    System.out.println(ejecutable.getNombre());
                    procesosEjecutable.add(ejecutable);
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return ;
            }
        }); 
        return procesosEjecutable;
    }

    /**
     * Metodo que se encarga de retornar los procesos
     * @return procesos - ArrayList de procesos
     */
    public ArrayList<Proceso> sacarProcesos(){
        ArrayList<Proceso> procesos = new ArrayList<>();
        procesos.addAll(sacarDocumentos());
        procesos.addAll(sacarMultimedia());
        procesos.addAll(sacarEjecutables());
        return procesos;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ESPERA" y que sean de tipo Documento
     * @return procesosEnEspera - ArrayList de procesos con el estado de "ESPERA"
     */
    private ArrayList<Documento> sacarDocumentosEnEspera(){
        ArrayList<Documento> procesosEnEspera = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado().equals("ESPERA")) {
                        System.out.println(documento.getNombre());
                        procesosEnEspera.add(documento);
                    }
                });
            }
            else{
                System.out.println("No hay documentos");
                return ;
            }
        }); 
        return procesosEnEspera;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "FINALIZADO" y que sean de tipo Documento
     * @return procesosFinalizados - ArrayList de procesos con el estado de "FINALIZADO"
     */
    private ArrayList<Documento> sacarDocumentosFinalizados(){
        ArrayList<Documento> procesosFinalizados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado().equals("FINALIZADO")) {
                        System.out.println(documento.getNombre());
                        procesosFinalizados.add(documento);
                    }
                });
            }
            else{
                System.out.println("No hay documentos");
                return ;
            }
        }); 
        return procesosFinalizados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ASIGNADO" y que sean de tipo Documento
     * @return procesosAsignados - ArrayList de procesos con el estado de "ASIGNADO"
     */
    private ArrayList<Documento> sacarDocumentosAsignados(){
        ArrayList<Documento> procesosAsignados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado().equals("ASIGNADO")) {
                        System.out.println(documento.getNombre());
                        procesosAsignados.add(documento);
                    }
                });
            }
            else{
                System.out.println("No hay documentos");
                return ;
            }
        }); 
        return procesosAsignados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ESPERA" y que sean de tipo Multimedia
     * @return procesosEnEspera - ArrayList de procesos con el estado de "ESPERA"
     */
    private ArrayList<Proceso> sacarMultimediaEnEspera(){
        ArrayList<Proceso> procesosEnEspera = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado().equals("ESPERA")) {
                        System.out.println(multimedia.getNombre());
                        procesosEnEspera.add(multimedia);
                    }
                });
            }
            else{
                System.out.println("No hay multimedia");
                return ;
            }
        }); 
        return procesosEnEspera;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "FINALIZADO" y que sean de tipo Multimedia
     * @return procesosFinalizados - ArrayList de procesos con el estado de "FINALIZADO"
     */
    private ArrayList<Proceso> sacarMultimediaFinalizados(){
        ArrayList<Proceso> procesosFinalizados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado().equals("FINALIZADO")) {
                        System.out.println(multimedia.getNombre());
                        procesosFinalizados.add(multimedia);
                    }
                });
            }
            else{
                System.out.println("No hay multimedia");
                return ;
            }
        }); 
        return procesosFinalizados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ASIGNADO" y que sean de tipo Multimedia
     * @return procesosAsignados - ArrayList de procesos con el estado de "ASIGNADO"
     */
    private ArrayList<Proceso> sacarMultimediaAsignados(){
        ArrayList<Proceso> procesosAsignados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado().equals("ASIGNADO")) {
                        System.out.println(multimedia.getNombre());
                        procesosAsignados.add(multimedia);
                    }
                });
            }
            else{
                System.out.println("No hay multimedia");
                return ;
            }
        }); 
        return procesosAsignados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ESPERA" y que sean de tipo Ejecutable
     * @return procesosEnEspera - ArrayList de procesos con el estado de "ESPERA"
     */
    private ArrayList<Proceso> sacarEjecutablesEnEspera(){
        ArrayList<Proceso> procesosEnEspera = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado().equals("ESPERA")) {
                        System.out.println(ejecutable.getNombre());
                        procesosEnEspera.add(ejecutable);
                    }
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return ;
            }
        }); 
        return procesosEnEspera;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "FINALIZADO" y que sean de tipo Ejecutable
     * @return procesosFinalizados - ArrayList de procesos con el estado de "FINALIZADO"
     */
    private ArrayList<Proceso> sacarEjecutablesFinalizados(){
        ArrayList<Proceso> procesosFinalizados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado().equals("FINALIZADO")) {
                        System.out.println(ejecutable.getNombre());
                        procesosFinalizados.add(ejecutable);
                    }
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return ;
            }
        }); 
        return procesosFinalizados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ASIGNADO" y que sean de tipo Ejecutable
     * @return procesosAsignados - ArrayList de procesos con el estado de "ASIGNADO"
     */
    private ArrayList<Proceso> sacarEjecutablesAsignados(){
        ArrayList<Proceso> procesosAsignados = new ArrayList<>();
        this.manejo.getLector().forEach((lector) -> {
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado().equals("ASIGNADO")) {
                        System.out.println(ejecutable.getNombre());
                        procesosAsignados.add(ejecutable);
                    }
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return ;
            }
        }); 
        return procesosAsignados;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ESPERA"
     * @return procesos - ArrayList de procesos con el estado de "ESPERA"
     */
    private ArrayList<Proceso> sacarProcesosEnEspera(){
        ArrayList<Proceso> procesos = new ArrayList<>();
        if (sacarDocumentosEnEspera().size() != 0) {
            procesos.addAll(sacarDocumentosEnEspera());
        }
        if (sacarMultimediaEnEspera().size() != 0) {
            procesos.addAll(sacarMultimediaEnEspera());
        }
        if (sacarEjecutablesEnEspera().size() != 0) {
            procesos.addAll(sacarEjecutablesEnEspera());
        }
        if (procesos.size() == 0) {
            System.out.println("No hay procesos en espera");
        }
        return procesos;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "FINALIZADO"
     * @return procesos - ArrayList de procesos con el estado de "FINALIZADO"
     */
    private ArrayList<Proceso> sacarProcesosFinalizados(){
        ArrayList<Proceso> procesos = new ArrayList<>();
        if (sacarDocumentosFinalizados().size() != 0) {
            procesos.addAll(sacarDocumentosFinalizados());
        }
        if (sacarMultimediaFinalizados().size() != 0) {
            procesos.addAll(sacarMultimediaFinalizados());
        }
        if (sacarEjecutablesFinalizados().size() != 0) {
            procesos.addAll(sacarEjecutablesFinalizados());
        }
        if (procesos.size() == 0) {
            System.out.println("No hay procesos finalizados");
        }
        return procesos;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado de "ASIGNADO"
     * @return procesos - ArrayList de procesos con el estado de "ASIGNADO"
     */
    private ArrayList<Proceso> sacarProcesosAsignados(){
        ArrayList<Proceso> procesos = new ArrayList<>();
        if (sacarDocumentosAsignados().size() != 0) {
            procesos.addAll(sacarDocumentosAsignados());
        }
        if (sacarMultimediaAsignados().size() != 0) {
            procesos.addAll(sacarMultimediaAsignados());
        }
        if (sacarEjecutablesAsignados().size() != 0) {
            procesos.addAll(sacarEjecutablesAsignados());
        }
        if (procesos.size() == 0) {
            System.out.println("No hay procesos asignados");
        }
        return procesos;
    }

    /**
     * Metodo que se encarga de retornar los procesos con el estado que se le pase por parametro
     * @param estado - Estado de los procesos
     * @return procesos - ArrayList de procesos con el estado que se le pase por parametro
     */
    public ArrayList<Proceso> sacarProcesosPorEstado(String estado){
        ArrayList<Proceso> procesos = new ArrayList<>();
        if (estado.equals("ESPERA")) {
            procesos.addAll(sacarProcesosEnEspera());
        }
        else if (estado.equals("FINALIZADO")) {
            procesos.addAll(sacarProcesosFinalizados());
        }
        else if (estado.equals("ASIGNADO")) {
            procesos.addAll(sacarProcesosAsignados());
        }
        else{
            System.out.println("No hay procesos con ese estado");
        }
        return procesos;
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ASIGNADO de tipo Documento
     */
    private void imprimirDocumentosAsignados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Documentos asignados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado() == Estado.ASIGNADO) {
                        System.out.println("Nombre: " + documento.getNombre());
                        System.out.println("Tamaño: " + documento.getTamano());
                        System.out.println("Duracion: " + documento.getDuracion());
                        System.out.println("Tipo: " + documento.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay documentos");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ASIGNADO de tipo Multimedia
     */
    private void imprimirMultimediaAsignados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Multimedia asignados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado() == Estado.ASIGNADO) {
                        System.out.println("Nombre: " + multimedia.getNombre());
                        System.out.println("Tamaño: " + multimedia.getTamano());
                        System.out.println("Duracion: " + multimedia.getDuracion());
                        System.out.println("Tipo: " + multimedia.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay multimedia");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ASIGNADO de tipo Ejecutable
     */
    private void imprimirEjecutablesAsignados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Ejecutables asignados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado() == Estado.ASIGNADO) {
                        System.out.println("Nombre: " + ejecutable.getNombre());
                        System.out.println("Tamaño: " + ejecutable.getTamano());
                        System.out.println("Duracion: " + ejecutable.getDuracion());
                        System.out.println("Tipo: " + ejecutable.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ASIGNADO
     */
    private void imprimirProcesosAsignados(){
        if (sacarDocumentosAsignados().size() != 0) {
            imprimirDocumentosAsignados();
        }
        if (sacarMultimediaAsignados().size() != 0) {
            imprimirMultimediaAsignados();
        }
        if (sacarEjecutablesAsignados().size() != 0) {
            imprimirEjecutablesAsignados();
        }
        if (sacarDocumentosAsignados().size() == 0 && sacarMultimediaAsignados().size() == 0 && sacarEjecutablesAsignados().size() == 0) {
            System.out.println("No hay procesos asignados");
        }
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado FINALIZADO de tipo Documento
     */
    private void imprimirDocumentosFinalizados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Documentos finalizados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado() == Estado.FINALIZADO) {
                        System.out.println("Nombre: " + documento.getNombre());
                        System.out.println("Tamaño: " + documento.getTamano());
                        System.out.println("Duracion: " + documento.getDuracion());
                        System.out.println("Tipo: " + documento.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay documentos");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado FINALIZADO de tipo Multimedia
     */
    private void imprimirMultimediaFinalizados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Multimedia finalizados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado() == Estado.FINALIZADO) {
                        System.out.println("Nombre: " + multimedia.getNombre());
                        System.out.println("Tamaño: " + multimedia.getTamano());
                        System.out.println("Duracion: " + multimedia.getDuracion());
                        System.out.println("Tipo: " + multimedia.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay multimedia");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado FINALIZADO de tipo Ejecutable
     */
    private void imprimirEjecutablesFinalizados(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Ejecutables finalizados");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado() == Estado.FINALIZADO) {
                        System.out.println("Nombre: " + ejecutable.getNombre());
                        System.out.println("Tamaño: " + ejecutable.getTamano());
                        System.out.println("Duracion: " + ejecutable.getDuracion());
                        System.out.println("Tipo: " + ejecutable.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado FINALIZADO
     */
    private void imprimirProcesosFinalizados(){
        if (sacarDocumentosFinalizados().size() != 0) {
            imprimirDocumentosFinalizados();
        }
        if (sacarMultimediaFinalizados().size() != 0) {
            imprimirMultimediaFinalizados();
        }
        if (sacarEjecutablesFinalizados().size() != 0) {
            imprimirEjecutablesFinalizados();
        }
        if (sacarDocumentosFinalizados().size() == 0 && sacarMultimediaFinalizados().size() == 0 && sacarEjecutablesFinalizados().size() == 0) {
            System.out.println("No hay procesos finalizados");
        }
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ESPERA de tipo Documento
     */
    private void imprimirDocumentosEnEspera(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Documentos en espera");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getDocumentos().size() != 0) {
                lector.getDocumentos().forEach((documento) -> {
                    if (documento.getEstado() == Estado.ESPERA) {
                        System.out.println("Nombre: " + documento.getNombre());
                        System.out.println("Tamaño: " + documento.getTamano());
                        System.out.println("Duracion: " + documento.getDuracion());
                        System.out.println("Tipo: " + documento.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay documentos");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ESPERA de tipo Multimedia
     */
    private void imprimirMultimediaEnEspera(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Multimedia en espera");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getMultimedia().size() != 0) {
                lector.getMultimedia().forEach((multimedia) -> {
                    if (multimedia.getEstado() == Estado.ESPERA) {
                        System.out.println("Nombre: " + multimedia.getNombre());
                        System.out.println("Tamaño: " + multimedia.getTamano());
                        System.out.println("Duracion: " + multimedia.getDuracion());
                        System.out.println("Tipo: " + multimedia.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay multimedia");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ESPERA de tipo Ejecutable
     */
    private void imprimirEjecutablesEnEspera(){
        this.manejo.getLector().forEach((lector) -> {
            System.out.println("Ejecutables en espera");
            System.out.println("Del Usario: " + lector.getUsuario());
            if (lector.getEjecutables().size() != 0) {
                lector.getEjecutables().forEach((ejecutable) -> {
                    if (ejecutable.getEstado() == Estado.ESPERA) {
                        System.out.println("Nombre: " + ejecutable.getNombre());
                        System.out.println("Tamaño: " + ejecutable.getTamano());
                        System.out.println("Duracion: " + ejecutable.getDuracion());
                        System.out.println("Tipo: " + ejecutable.getTipo());
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            else{
                System.out.println("No hay ejecutables");
                return;
            }
        });
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado ESPERA
     */
    private void imprimirProcesosEnEspera(){
        if (sacarDocumentosEnEspera().size() != 0) {
            imprimirDocumentosEnEspera();
        }
        if (sacarMultimediaEnEspera().size() != 0) {
            imprimirMultimediaEnEspera();
        }
        if (sacarEjecutablesEnEspera().size() != 0) {
            imprimirEjecutablesEnEspera();
        }
        if (sacarDocumentosEnEspera().size() == 0 && sacarMultimediaEnEspera().size() == 0 && sacarEjecutablesEnEspera().size() == 0) {
            System.out.println("No hay procesos en espera");
        }
    }

    /**
     * Metodo que se encarga de imprimir los procesos con el estado que se le pase por parametro
     * @param estado - Estado de los procesos
     */
    public void imprimirProcesosPorEstado(Estado estado){
        if (estado == Estado.ESPERA) {
            imprimirProcesosEnEspera();
        }
        else if (estado == Estado.FINALIZADO) {
            imprimirProcesosFinalizados();
        }
        else if (estado == Estado.ASIGNADO) {
            imprimirProcesosAsignados();
        }
        else{
            System.out.println("No hay procesos con ese estado");
        }
    }

    /**
     * Metodo que se encarga de imprimir los procesos en orden de estado
     */
    public void imprimirProcesos(){
        System.out.println("Procesos en orden de estado");
        System.out.println("====================================");
        System.out.println("Procesos en espera:\n");
        imprimirProcesosEnEspera();
        System.out.println("====================================");
        System.out.println("Procesos asignados:\n");
        imprimirProcesosAsignados();
        System.out.println("====================================");
        System.out.println("Procesos finalizados:\n");
        imprimirProcesosFinalizados();
        System.out.println("====================================");
    }

}
