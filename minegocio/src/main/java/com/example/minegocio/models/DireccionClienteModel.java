package com.example.minegocio.models;

public class DireccionClienteModel {

    private Integer idAddress;
    private Integer idCliente;
    private String typeAddress;
    private String province;
    private String ciudad;
    private String address;
    
    public Integer getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
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
    
}
