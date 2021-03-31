package com.bookstore.system.controller;

import com.bookstore.system.model.dto.CategoriaDTO;
import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.service.CategoraiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoraiService categoraiService;

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
         categoria = categoraiService.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> findId(@PathVariable  Long id){
        Categoria categoria = categoraiService.findId(id);

        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = categoraiService.findAll();
        //convetendo uma lista para DTO
        List<CategoriaDTO> listDTO = list.stream()
                .map(obj -> new CategoriaDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody  CategoriaDTO categoriaDTO){
        Categoria newCategoria = categoraiService.update(id, categoriaDTO);

        return ResponseEntity.ok().body(new CategoriaDTO(newCategoria));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        categoraiService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
