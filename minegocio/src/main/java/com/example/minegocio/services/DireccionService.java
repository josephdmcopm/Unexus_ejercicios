package com.example.minegocio.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minegocio.models.DireccionModel;
import com.example.minegocio.repositories.DireccionRepository;

@Service
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;
    
    public ArrayList<DireccionModel> obtenerDireccion(){
        return (ArrayList<DireccionModel>) direccionRepository.findAll();
    }

    public Optional<DireccionModel> obtenerIdDireccion(Long id){
        return direccionRepository.findById(id);
    }

    public ArrayList<DireccionModel> obtenerPorIdCliente(Long long1){
        return direccionRepository.findByIdCliente(long1);
    }    

    public DireccionModel guardarDireccion(DireccionModel direccion){
        return direccionRepository.save(direccion);
    }

    public boolean eliminarDireccion(Long id){
        try{
            direccionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }  
}
