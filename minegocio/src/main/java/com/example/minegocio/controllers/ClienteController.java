package com.example.minegocio.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minegocio.models.ClienteDireccionModel;
import com.example.minegocio.models.ClienteModel;
import com.example.minegocio.models.DireccionModel;
import com.example.minegocio.services.ClienteService;

import jakarta.websocket.ClientEndpoint;

@RestController
@RequestMapping("/cliente")
public class ClienteController {    
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping()
    public ResponseEntity<ClienteModel> guardarUsuario(@RequestBody ClienteModel cliente){
        boolean ban = this.clienteService.validarClienteIdentificacion(cliente.getIdIdentification());
        if (ban == false){
            return ResponseEntity.ok(salidaError());
        }        
        ClienteModel clienteAux = this.clienteService.obtenerClienteId(cliente.getIdIdentification());
        cliente.setIdCliente(clienteAux.getIdCliente());
        return ResponseEntity.ok(this.clienteService.guardarCliente(cliente));
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") Long id){
        return this.clienteService.obtenerPorId(id);
    }

    @GetMapping("/queryIdentificacion")
    public ArrayList<ClienteModel> obtenerClientePorIdentificacion(@RequestParam("identificacion") String identificacion){
        return this.clienteService.obtenerPorIdentificacion(identificacion);
    }

    @GetMapping("/queryNombre")
    public ArrayList<ClienteModel> obtenerClientePorNombre(@RequestParam("nombre") String nombre){
        return this.clienteService.obtenerPorNombre(nombre);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable ("id") Long id){
        boolean ok =this.clienteService.eliminarCliente(id);
        if (ok){
            return "Se elimino cliente con id "+ id;
        }else{
            return "No pudo eliminar el cliente con id "+ id;
        }
    }


    public ClienteModel salidaError(){        
        ClienteModel cliente = new ClienteModel();        
        cliente.setIdIdentification("CLIENTE NO EXISTE");                        
        return cliente;
    }
}
