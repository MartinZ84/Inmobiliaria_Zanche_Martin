package com.devmhz.inmobiliaria_zanche_martin.modelo;


import java.io.Serializable;

public class Inquilino implements Serializable {

    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String lugar_Trabajo;
    private String email;
    private String telefono;



    public Inquilino() {}

    public Inquilino(int id, String dni, String nombre, String apellido, String lugar_Trabajo, String email, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugar_Trabajo = lugar_Trabajo;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLugar_Trabajo() {
        return lugar_Trabajo;
    }

    public void setLugar_Trabajo(String lugar_Trabajo) {
        this.lugar_Trabajo = lugar_Trabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    @Override
    public String toString() {
        return getNombre() +" "+getApellido();
    }

}
