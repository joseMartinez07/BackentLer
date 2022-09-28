package com.example.listado.Controller;

import com.example.listado.Model.ModeloUsuario;
import com.example.listado.Services.ServicesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/persona")
public class ControllerUsuario {
    @Autowired
    ServicesUsuario servicesUsuario;

    @GetMapping()
    public ArrayList<ModeloUsuario> obtenerUsuario(){
        return servicesUsuario.obtenerUsuario();
    }

    @PostMapping()
    public ModeloUsuario guardarUsuario(@RequestBody ModeloUsuario usuario){
        return this.servicesUsuario.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<ModeloUsuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.servicesUsuario.ObtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean obj = this.servicesUsuario.eliminarUsuario(id);
        if (obj){
            return "se elimino el usuario por su id " + id;
        }else {
            return "no se encontro la persona con id " + id + ", no se pudo eliminar";
        }
    }
}
