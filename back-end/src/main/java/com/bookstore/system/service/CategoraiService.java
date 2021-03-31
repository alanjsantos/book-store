package com.bookstore.system.service;

import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.repository.CategoriaResposiroty;
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

        return catogoria.orElse(null);
    }

    @Transactional
    public Categoria save (Categoria categoria){

        return categoriaResposiroty.save(categoria);
    }
}
