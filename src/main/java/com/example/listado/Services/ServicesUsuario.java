package com.example.listado.Services;

import com.example.listado.Model.ModeloUsuario;
import com.example.listado.Repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicesUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public ArrayList<ModeloUsuario> obtenerUsuario(){
        return (ArrayList<ModeloUsuario>) repositoryUsuario.findAll();
    }
    public ModeloUsuario guardarUsuario(ModeloUsuario usuario){
        return repositoryUsuario.save(usuario);
    }

    public Optional<ModeloUsuario> ObtenerPorId(Long id){
        return repositoryUsuario.findById(id);
    }
    public boolean eliminarUsuario(Long id){
        try {
            repositoryUsuario.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }

    }
}
