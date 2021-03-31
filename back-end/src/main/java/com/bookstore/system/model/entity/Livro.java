package com.bookstore.system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    private Long id;
    private String titulo;
    private String nomeAutor;
    private String texto;
    private Categoria categoria;

}
