package com.springjpa.estudandospringjpa.repositories;

import com.springjpa.estudandospringjpa.domain.Categoria;
import com.springjpa.estudandospringjpa.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findById(Integer id);

    //JPQ
  //  @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
  //  Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, PageRequest pageRequest);


    @Transactional(readOnly = true)
    Page<Produto> findDistinctByNomeContainingAndAndCategoriasIn(String nome, List<Categoria> categorias, PageRequest pageRequest);
}
