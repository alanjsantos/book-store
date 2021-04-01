package com.bookstore.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Campo TITULO é obrigatório.")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 catacteres.")
    private String titulo;

    @NotEmpty(message = "O Campo NOME DO AUTOR é obrigatório.")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 catacteres.")
    private String nomeAutor;

    @NotEmpty(message = "O Campo TEXTO é obrigatório.")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 3 e 200000 catacteres.")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

}
