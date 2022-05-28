package com.devmhz.inmobiliaria_zanche_martin.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {

    private int id;
    private String direccion;
    private String uso;
    private String tipo;
    private int ambientes;
    private int precio;
    private double superficie;
    private double latitud;
    private double longitud;
    private int propietarioId;
    private Propietario propietario;

    //En falso significa que el innmueble no está disponible por alguna falla en el mismo.
    private String estado;
    private boolean estadoInmueble=true;
    private String imagen;
    private String foto;

    public Inmueble(int id, String direccion, String uso, String tipo, int ambientes,
                    int precio, double superficie, String estado, String imagen) {
        this.id = id;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.precio = precio;
        this.superficie = superficie;
        this.estado=estado;
        this.imagen = imagen;
    }

    public Inmueble(int id, String direccion, String uso, String tipo, int ambientes,
                    int precio, double superficie, String estado, boolean estadoInmueble, String imagen, String foto) {
        this.id = id;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.precio = precio;
        this.superficie = superficie;
        this.estado=estado;
        this.estadoInmueble=estadoInmueble;
        this.imagen = imagen;
        this.foto=foto;
    }

    public Inmueble(int id, String direccion, String uso, String tipo, int ambientes, int precio, Propietario propietario, String estado, String imagen, String foto) {
        this.id = id;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.precio = precio;
        this.propietario = propietario;
        this.estado = estado;
        this.imagen = imagen;
        this.foto=foto;
    }

    public Inmueble(int id, String direccion, String uso, String tipo, int ambientes, int precio, double superficie, String estado, boolean estadoInmueble, String imagen) {
        this.id = id;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.ambientes = ambientes;
        this.precio = precio;
        this.propietario = propietario;
        this.estado = estado;
        this.imagen = imagen;
    }


    public int getId() {
        return id;
    }

    public void setId(int idInmueble) {
        this.id = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEstadoInmueble() {
        return estadoInmueble;
    }

    public void setEstadoInmueble(boolean estado) {
        this.estadoInmueble = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return id == inmueble.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Ubicado en: " + getDireccion();
    }
}

