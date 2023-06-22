package com.example.minegocio.controllers;

import java.util.ArrayList;

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
import com.example.minegocio.services.DireccionService;

@RestController
@RequestMapping("/clienteDireccion")
public class ClienteDireccionController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    DireccionService direccionService;

    @GetMapping("/queryIde")
    public ResponseEntity<ArrayList<ClienteDireccionModel>> obtenerClientePorIdentificacion(@RequestParam("identificacion") String identificacion){
        ArrayList<ClienteDireccionModel> datos = new ArrayList<ClienteDireccionModel>();
        ArrayList<ClienteModel> cliente = this.clienteService.obtenerPorIdentificacion(identificacion);
        ClienteModel clienteAux = cliente.get(0);
        ArrayList<DireccionModel> direccion = this.direccionService.obtenerPorIdCliente(clienteAux.getIdCliente());

        
        for (int i=0; i < direccion.size(); i++){
            ClienteDireccionModel dato = new ClienteDireccionModel();
            dato.setClienteModel(cliente.get(0));
            dato.setDireccionModel(direccion.get(i));
            datos.add(dato);
        }

        return ResponseEntity.ok(datos);
    }


    @GetMapping("/queryName")
    public ResponseEntity<ArrayList<ClienteDireccionModel>> obtenerClientePorNombre(@RequestParam("nombre") String nombre){
        ArrayList<ClienteDireccionModel> datos = new ArrayList<ClienteDireccionModel>();
        ArrayList<ClienteModel> cliente = this.clienteService.obtenerPorNombre(nombre);

        for (int a=0; a<cliente.size(); a++){
            ClienteModel clienteAux = cliente.get(a);
            ArrayList<DireccionModel> direccion = this.direccionService.obtenerPorIdCliente(clienteAux.getIdCliente());

            for (int i=0; i < direccion.size(); i++){
                ClienteDireccionModel dato = new ClienteDireccionModel();
                dato.setClienteModel(cliente.get(0));
                dato.setDireccionModel(direccion.get(i));
                datos.add(dato);
            }
        }

        return ResponseEntity.ok(datos);
    }

    @GetMapping()
    public ArrayList<DireccionModel> obtenerDirecciones(){
        return direccionService.obtenerDireccion();
    }

    
    @PostMapping()
    public ResponseEntity<ClienteDireccionModel> guardarClienteDireccion(@RequestBody ClienteDireccionModel datos){
        
        ClienteModel cliente = datos.getClienteModel();
        DireccionModel direccion =datos.getDireccionModel();  
        
        boolean ban = this.clienteService.validarClienteIdentificacion(cliente.getIdIdentification());
        if (ban == true){
            return ResponseEntity.ok(salidaError());
        }        

        this.clienteService.guardarCliente(cliente);        

        ClienteModel clienteAux = this.clienteService.obtenerPorIdentificacion(cliente.getIdIdentification()).get(0);        
        direccion.setIdCliente(clienteAux.getIdCliente());
        direccion.setTypeAddress("MATRIZ");
        this.direccionService.guardarDireccion(direccion);
        
        return ResponseEntity.ok(datos);
    }

    

    public ClienteDireccionModel salidaError(){
        ClienteDireccionModel dato = new ClienteDireccionModel();
        ClienteModel cliente = new ClienteModel();
        DireccionModel direccion = new DireccionModel();
        cliente.setIdIdentification("ERROR IDENTIFICACION YA EXISTE");          
        dato.setClienteModel(cliente);
        dato.setDireccionModel(direccion);
        return dato;
    }


    //@DeleteMapping(path = "/{id}")
    //public String eliminarPorId(@PathVariable ("id") Long id){        
    //    ArrayList<DireccionModel> direccion = this.direccionService.obtenerPorIdCliente(id);        
    //    boolean ok =this.clienteService.eliminarCliente(id);

    //    for (int i =0 ; i<direccion.size(); i++){
    //        DireccionModel direccionAux = new DireccionModel();
    //        direccionAux = direccion.get(i);
    //        //this.direccionService.eliminarDireccion(direccionAux.get)
    //    }
    //    if (ok){
    //        return "Se elimino cliente con id "+ id;
    //    }else{
    //        return "No pudo eliminar el cliente con id "+ id;
    //    }
    //}


}
