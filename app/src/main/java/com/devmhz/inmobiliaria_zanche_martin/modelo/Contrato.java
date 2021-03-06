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
    private String nombre_Garante;
    private String apellido_Garante;
    private String telefono_Garante;


    public Contrato(int id, String fechaInicio, String fechaFin, int precio, String estado, Inquilino inquilino, Inmueble inmueble, String nombre_Garante, String apellido_Garante, String telefono_Garante) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.estado = estado;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.nombre_Garante = nombre_Garante;
        this.apellido_Garante = apellido_Garante;
        this.telefono_Garante = telefono_Garante;
    }

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

    public String getNombre_Garante() {
        return nombre_Garante;
    }

    public void setNombre_Garante(String nombre_Garante) {
        this.nombre_Garante = nombre_Garante;
    }

    public String getApellido_Garante() {
        return apellido_Garante;
    }

    public void setApellido_Garante(String apellido_Garante) {
        this.apellido_Garante = apellido_Garante;
    }

    public String getTelefono_Garante() {
        return telefono_Garante;
    }

    public void setTelefono_Garante(String telefono_Garante) {
        this.telefono_Garante = telefono_Garante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id;
    }


    public String fechaInicio() {
        String a??o = getFechaInicio().substring(0,4);
        String mes = getFechaInicio().substring(5,7);
        String dia = getFechaInicio().substring(8,10);
        return "Fecha Inicio: " + dia +"/"+mes+"/"+a??o;
    }

    public String fechaFin() {
        String a??o = getFechaFin().substring(0,4);
        String mes = getFechaFin().substring(5,7);
        String dia = getFechaFin().substring(8,10);
        return "Fecha Fin: " + dia +"/"+mes+"/"+a??o;
    }

    public String fechaInicioOnly() {
        String a??o = getFechaInicio().substring(0,4);
        String mes = getFechaInicio().substring(5,7);
        String dia = getFechaInicio().substring(8,10);
        return dia +"/"+mes+"/"+a??o;
    }

    public String fechaFinOnly() {
        String a??o = getFechaFin().substring(0,4);
        String mes = getFechaFin().substring(5,7);
        String dia = getFechaFin().substring(8,10);
        return dia +"/"+mes+"/"+a??o;
    }

    @Override
    public String toString() {
        return "Ubicaci??n: " + getInmueble().getDireccion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
