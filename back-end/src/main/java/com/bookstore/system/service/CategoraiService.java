package com.bookstore.system.service;

import com.bookstore.system.model.dto.CategoriaDTO;
import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.repository.CategoriaResposiroty;
import com.bookstore.system.service.exception.DataIntegrityViolationException;
import com.bookstore.system.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoraiService {

    @Autowired
    private CategoriaResposiroty categoriaResposiroty;


    @Transactional
    public Categoria save (Categoria categoria){
        categoria.setId(null);

        return categoriaResposiroty.save(categoria);
    }

    public  Categoria findId(Long id){
        Optional<Categoria> catogoria = categoriaResposiroty.findById(id);

        return catogoria.orElseThrow(() -> new ObjectNotFoundException("ID " + id + " não encontrado!"));
    }

    public List<Categoria> findAll(){
        return categoriaResposiroty.findAll();
    }

    @Transactional
    public Categoria update(Long id, CategoriaDTO categoriaDTO){
        Categoria obj = findId(id);
        categoriaDTO.setId(id);
        obj.setNome(categoriaDTO.getNome());
        obj.setDescricao(categoriaDTO.getDescricao());

        return categoriaResposiroty.save(obj);
    }

    @Transactional
    public void delete(Long id){
        findId(id);

        try {
            categoriaResposiroty.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Categoria não pode ser deletado. Possui Livros associados!");
        }
        categoriaResposiroty.deleteById(id);
    }

}
