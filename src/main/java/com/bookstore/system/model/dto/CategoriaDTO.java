package com.bookstore.system.model.dto;

import com.bookstore.system.model.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "O Campo NOME é obrigatório.")
    @Length(min = 3, max = 80, message = "O campo NOME deve ter entre 3 e 80 catacteres.")
    private String nome;

    @NotEmpty(message = "O Campo DESCRIÇÃO é obrigatório.")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 catacteres.")
    private String descricao;

    //conversao de DTO para ENTIDADE.
    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
