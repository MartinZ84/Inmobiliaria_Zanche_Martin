package com.devmhz.inmobiliaria_zanche_martin.modelo;


import java.io.Serializable;
import java.time.LocalDate;

public class Pago implements Serializable {

    private int id;
    private int nroPago;
    private Contrato contrato;
    private int contratoId;
    private double importe;
    private String fechaDePago;

    public Pago(int id, int nroPago, double importe, String fechaDePago,int contratoId) {
        this.id = id;
        this.nroPago = nroPago;
        this.importe = importe;
        this.fechaDePago = fechaDePago;
        this.contratoId=  contratoId;
    }

    public Pago(int id, int nroPago, Contrato contrato, double importe, String fechaDePago, int contratoId) {
        this.id = id;
        this.nroPago = nroPago;
        this.contrato = contrato;
        this.importe = importe;
        this.fechaDePago = fechaDePago;
        this.contratoId=  contratoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public String fechaPago() {
        String año = getFechaDePago().substring(0,4);
        String mes = getFechaDePago().substring(5,7);
        String dia = getFechaDePago().substring(8,10);
        return dia +"/"+mes+"/"+año;
    }
}
