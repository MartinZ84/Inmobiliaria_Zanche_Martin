package com.devmhz.inmobiliaria_zanche_martin.modelo;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Contrato implements Serializable {

    private int id;
    private String fechaInicio;
    private String fechaFin;
    private int precio;
    private String estado;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Contrato() {}
    public Contrato(int id, String fechaInicio, String fechaFin, int precio, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public Contrato(int id, String fechaInicio, String fechaFin, int precio, String estado, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.estado = estado;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public int getIdContrato() {
        return id;
    }

    public void setIdContrato(int idContrato) {
        this.id = idContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id;
    }


    public String fechaInicio() {
        String año = getFechaInicio().substring(0,4);
        String mes = getFechaInicio().substring(5,7);
        String dia = getFechaInicio().substring(8,10);
        return "Fecha Inicio: " + dia +"/"+mes+"/"+año;
    }

    public String fechaFin() {
        String año = getFechaFin().substring(0,4);
        String mes = getFechaFin().substring(5,7);
        String dia = getFechaFin().substring(8,10);
        return "Fecha Fin: " + dia +"/"+mes+"/"+año;
    }

    public String fechaInicioOnly() {
        String año = getFechaInicio().substring(0,4);
        String mes = getFechaInicio().substring(5,7);
        String dia = getFechaInicio().substring(8,10);
        return dia +"/"+mes+"/"+año;
    }

    public String fechaFinOnly() {
        String año = getFechaFin().substring(0,4);
        String mes = getFechaFin().substring(5,7);
        String dia = getFechaFin().substring(8,10);
        return dia +"/"+mes+"/"+año;
    }

    @Override
    public String toString() {
        return "Ubicación: " + getInmueble().getDireccion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
