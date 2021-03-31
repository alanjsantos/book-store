package com.bookstore.system.repository;

import com.bookstore.system.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaResposiroty extends JpaRepository<Categoria, Long> {

}
