package com.example.listado.Repositories;

import com.example.listado.Model.ModeloUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUsuario extends CrudRepository<ModeloUsuario, Long> {
    public abstract Optional<ModeloUsuario> findById(Long id);
}