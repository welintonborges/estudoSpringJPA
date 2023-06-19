package com.springjpa.estudandospringjpa.repositories;

import com.springjpa.estudandospringjpa.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

  

}
