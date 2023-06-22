package com.example.minegocio.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.minegocio.models.DireccionModel;
import java.util.List;

@Repository
public interface DireccionRepository extends CrudRepository<DireccionModel, Long>{
    public abstract ArrayList<DireccionModel> findByIdCliente(Long idCliente);
}
