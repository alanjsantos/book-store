package com.bookstore.system.model.dto;

import com.bookstore.system.model.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "O Campo TITULO é obrigatório.")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 catacteres.")
    private String titulo;

    //conversao de DTO para ENTIDADE.
    public LivroDTO (Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();

    }
}
