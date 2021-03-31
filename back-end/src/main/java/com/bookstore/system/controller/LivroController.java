package com.bookstore.system.controller;

import com.bookstore.system.model.dto.CategoriaDTO;
import com.bookstore.system.model.dto.LivroDTO;

import com.bookstore.system.model.entity.Livro;

import com.bookstore.system.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestParam(value = "categoria", defaultValue = "0") Long id,
                                      @RequestBody Livro livro){
        Livro newlivro = livroService.save(livro, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(newlivro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> findId(@PathVariable  Long id){
        Livro livro = livroService.findId(id);

        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat){
        List<Livro> list = livroService.findAll(id_cat);
        //convetendo uma lista para DTO
        List<LivroDTO> listDTO = list.stream()
                .map(obj -> new LivroDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody  LivroDTO livroDTO){
        Livro newLivro = livroService.update(id, livroDTO);

        return ResponseEntity.ok().body(new LivroDTO(newLivro));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        livroService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
