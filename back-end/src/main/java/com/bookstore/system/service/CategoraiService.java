package com.bookstore.system.service;

import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.repository.CategoriaResposiroty;
import com.bookstore.system.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoraiService {

    @Autowired
    private CategoriaResposiroty categoriaResposiroty;

    public  Categoria findId(Long id){
        Optional<Categoria> catogoria = categoriaResposiroty.findById(id);

        return catogoria.orElseThrow(() -> new ObjectNotFoundException("ID " + id + " não encontrado!"));
    }

    @Transactional
    public Categoria save (Categoria categoria){

        return categoriaResposiroty.save(categoria);
    }
}
