package com.springjpa.estudandospringjpa.repositories;

import com.springjpa.estudandospringjpa.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
