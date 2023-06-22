package com.example.minegocio.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minegocio.models.ClienteModel;
import com.example.minegocio.models.DireccionClienteModel;
import com.example.minegocio.models.DireccionModel;
import com.example.minegocio.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    @Autowired
    DireccionService direccionService;

    @PostMapping()
    public ResponseEntity<DireccionModel> guardarDireccion(@RequestBody DireccionClienteModel direccion){
        DireccionModel direccionAux = new DireccionModel();
        direccionAux.setIdCliente((long) direccion.getIdCliente());            
        direccionAux.setTypeAddress("SUCURSAL");   
        direccionAux.setProvince(direccion.getProvince());
        direccionAux.setCiudad(direccion.getCiudad());
        direccionAux.setAddress(direccion.getAddress());        
        return ResponseEntity.ok(this.direccionService.guardarDireccion(direccionAux));
    }

    @GetMapping("/queryIdCliente")
    public ArrayList<DireccionModel> obtenerDireccionPorIdCliente(@RequestParam("id") Integer id){
        return this.direccionService.obtenerPorIdCliente((long)id);
    }
}
