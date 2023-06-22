package com.example.minegocio.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.minegocio.models.ClienteModel;
import java.util.List;


@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {    
    public abstract ArrayList<ClienteModel> findByIdIdentification (String idIdentification); 
    public abstract ArrayList<ClienteModel> findByName(String name);        
}
