package com.example.minegocio.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente", indexes = @Index(name = "idxCli", columnList = "idIdentification, typeIdentification"))
public class ClienteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idCliente;    
    private String idIdentification;
    private String typeIdentification;
    private String name;
    private String mail;
    private String celular;
    
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getIdIdentification() {
        return idIdentification;
    }
    public void setIdIdentification(String idIdentification) {
        this.idIdentification = idIdentification;
    }
    public String getTypeIdentification() {
        return typeIdentification;
    }
    public void setTypeIdentification(String typeIdentification) {
        this.typeIdentification = typeIdentification;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    


    
}
