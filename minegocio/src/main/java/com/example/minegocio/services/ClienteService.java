package com.example.minegocio.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minegocio.models.ClienteModel;
import com.example.minegocio.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    
    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> obtenerPorId(Long id){
        return clienteRepository.findById(id);
    }
    
    public ArrayList<ClienteModel> obtenerPorIdentificacion(String identification){
        return (ArrayList<ClienteModel>)clienteRepository.findByIdIdentification(identification);
    }

    public boolean validarClienteIdentificacion(String identificacion){
        Integer nroCLiente = 0;
        nroCLiente = clienteRepository.findByIdIdentification(identificacion).size();
        if (nroCLiente >0 ){
            return true;
        }else {
            return false;
        }
    }

    public ClienteModel obtenerClienteId(String identificacion){        
        ArrayList<ClienteModel> cliente = clienteRepository.findByIdIdentification(identificacion);
        return cliente.get(0);
    }

    public ArrayList<ClienteModel> obtenerPorNombre(String name){
        return (ArrayList<ClienteModel>)clienteRepository.findByName(name);
    }

    public boolean eliminarCliente(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }    
}
