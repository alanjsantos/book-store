package com.bookstore.system.service;

import com.bookstore.system.model.dto.LivroDTO;
import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.model.entity.Livro;
import com.bookstore.system.repository.LivroRepository;
import com.bookstore.system.service.exception.DataIntegrityViolationException;
import com.bookstore.system.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoraiService categoraiService;

    @Transactional
    public Livro save (Livro livro, Long id_cat){
        livro.setId(null);
        Categoria categoria = categoraiService.findId(id_cat);
        livro.setCategoria(categoria);

        return livroRepository.save(livro);
    }

    public Livro findId(Long id){
        Optional<Livro> livro = livroRepository.findById(id);

        return livro.orElseThrow(() -> new ObjectNotFoundException("ID " + id + " não encontrado!"));
    }

    public List<Livro> findAll (Long id_Cat){
        categoraiService.findId(id_Cat);


        return livroRepository.findAllByCategoria(id_Cat);
    }

    @Transactional
    public Livro update (Long id, LivroDTO livroDTO){
        Livro obj = findId(id);
        livroDTO.setId(id);
        obj.setTitulo(livroDTO.getTitulo());

        return livroRepository.save(obj);

    }

    @Transactional
    public void delete(Long id){
       findId(id);
      livroRepository.deleteById(id);
    }
}
