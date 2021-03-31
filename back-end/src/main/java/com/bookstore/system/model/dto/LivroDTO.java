package com.bookstore.system.model.dto;

import com.bookstore.system.model.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable {

    private Long id;
    private String titulo;

    //conversao de DTO para ENTIDADE.
    public LivroDTO (Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();

    }
}
