package com.bookstore.system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Campo NOME é obrigatório.")
    @Length(min = 3, max = 80, message = "O campo NOME deve ter entre 3 e 80 catacteres.")
    private String nome;

    @NotEmpty(message = "O Campo DESCRIÇÃO é obrigatório.")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 catacteres.")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();
}
