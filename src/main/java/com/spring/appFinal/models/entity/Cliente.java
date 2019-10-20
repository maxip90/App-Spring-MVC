package com.spring.appFinal.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nombre;


    @Email
    private String email;

    //@OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne(mappedBy ="cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Turno turno;


    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    private static final long serialVersionUID = 1L;
}
