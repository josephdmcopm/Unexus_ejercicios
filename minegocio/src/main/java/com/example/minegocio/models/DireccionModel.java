package com.example.minegocio.models;

import java.util.concurrent.atomic.LongAccumulator;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table (name = "direccion")
public class DireccionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idAddress;

    private Long idCliente;
    private String typeAddress;
    private String province;
    private String ciudad;
    private String address;

    
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getTypeAddress() {
        return typeAddress;
    }
    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setIdCliente(String string) {
    }
    
}
