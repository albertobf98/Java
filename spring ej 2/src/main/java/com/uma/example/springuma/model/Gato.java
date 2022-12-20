package com.uma.example.springuma.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // para ignorar el serializador al devolver un objeto gato
public class Gato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    
    @Column(unique=true) 
    private String name;

    @Column(name = "Edad")
    private long Edad;

    @Column(name = "Color")
    private String Color;

    @ManyToOne
    private Raza raza;

    /*public Gato(long iD, String name, long edad, String color, Raza raza) {
        ID = iD;
        this.name = name;
        Edad = edad;
        Color = color;
        this.raza = raza;
    }*/

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEdad() {
        return Edad;
    }

    public void setEdad(long edad) {
        Edad = edad;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }


    
}
