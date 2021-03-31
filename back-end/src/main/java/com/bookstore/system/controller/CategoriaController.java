package com.bookstore.system.controller;

import com.bookstore.system.model.entity.Categoria;
import com.bookstore.system.service.CategoraiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoraiService categoraiService;

    @GetMapping("{id}")
    public ResponseEntity<Categoria> findId(@PathVariable  Long id){
        Categoria categoria = categoraiService.findId(id);

        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        Categoria categoriaSalva = categoraiService.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

}
