package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto gato
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    
    @Column(unique=true)
    private String Nombre;

    @Column(name = "Tamanyo")
    private String Tamanyo;

    @Column(name = "Amabilidad")
    private int Amabilidad;

    @Column(name = "Pelosidad")
    private int Pelosidad;

    /*public Raza(long iD, String nombre, String tamanyo, int amabilidad, int pelosidad) {
        ID = iD;
        Nombre = nombre;
        Tamanyo = tamanyo;
        Amabilidad = amabilidad;
        Pelosidad = pelosidad;
    }*/

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTamanyo() {
        return Tamanyo;
    }

    public void setTamanyo(String tamanyo) {
        Tamanyo = tamanyo;
    }

    public int getAmabilidad() {
        return Amabilidad;
    }

    public void setAmabilidad(int amabilidad) {
        Amabilidad = amabilidad;
    }

    public int getPelosidad() {
        return Pelosidad;
    }

    public void setPelosidad(int pelosidad) {
        Pelosidad = pelosidad;
    }

    @Override
    public String toString() {
        return "Raza [ID=" + ID + ", Nombre=" + Nombre + ", Tamanyo=" + Tamanyo + ", Amabilidad=" + Amabilidad
                + ", Pelosidad=" + Pelosidad + "]";
    }
}
