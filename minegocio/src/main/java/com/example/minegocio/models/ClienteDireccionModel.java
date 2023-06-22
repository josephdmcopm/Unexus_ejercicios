package com.example.minegocio.models;

import java.util.ArrayList;
import java.util.Optional;

import jakarta.persistence.*;

public class ClienteDireccionModel {

    private ClienteModel clienteModel;
    private DireccionModel direccionModel;
    public ClienteModel getClienteModel() {
        return clienteModel;
    }
    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
    public DireccionModel getDireccionModel() {
        return direccionModel;
    }
    public void setDireccionModel(DireccionModel direccionModel) {
        this.direccionModel = direccionModel;
    }

    
   

    
}
